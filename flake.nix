{
  description = "Nix flake-based Java development environment";
  inputs.nixpkgs.url = "github:nixos/nixpkgs/nixos-unstable";
  nixConfig = {
    extra-substituters = [ "https://cache.garnix.io" ];
    extra-trusted-public-keys = [ "cache.garnix.io:CTFPyKSLcx5RMJKfLo5EEPUObbA78b0YQ2DTCJXqr9g=" ];
  };
  outputs =
    { self, ... }@inputs:
    let
      systems =
        f:
        inputs.nixpkgs.lib.genAttrs
          [
            "x86_64-linux" # "aarch64-linux"
          ]
          (
            system:
            f {
              pkgs = import inputs.nixpkgs {
                inherit system;
                overlays = [ inputs.self.overlays.default ];
              };
            }
          );
    in
    {
      overlays.default =
        final: prev:
        let
          jdk = prev."jdk25";
        in
        {
          inherit jdk;
          maven = prev.maven.override { jdk_headless = jdk; };
          gradle = prev.gradle.override { java = jdk; };
        };
      packages = systems (
        { pkgs }:
        {
          idea-oss = pkgs.jetbrains.idea-oss;
          default = pkgs.jetbrains.idea-oss;
        }
      );
      devShells = systems (
        { pkgs }:
        {
          default = pkgs.mkShellNoCC {
            packages = with pkgs; [
              jdt-language-server # The Eclipse JDT Language Server
              jetbrains.idea-oss
              (pkgs.writeShellScriptBin "ide" "idea-oss &")
            ];
            buildInputs = with pkgs; [
              jdk # Java Development Kit
              maven # Or 'gradle' if you prefer
              gcc
              gradle
              ncurses
              patchelf
              zlib
            ];
            JAVA_HOME = "${pkgs.jdk}/lib/openjdk";
          };
        }
      );
    };
}
