{
  description = "A Nix flake Java development environment";
  inputs.nixpkgs.url = "github:nixos/nixpkgs/0b4bae10efcae2760534fb0d50d44e732432d28f";
  outputs =
    { self, ... }@inputs:
    let
      javaVersion = 25; # Change this value to update the whole stack
      systems =
        f:
        inputs.nixpkgs.lib.genAttrs
          [
            "x86_64-linux"
            "aarch64-linux"
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
          jdk = prev."jdk${toString javaVersion}";
        in
        {
          inherit jdk;
          maven = prev.maven.override { jdk_headless = jdk; };
          gradle = prev.gradle.override { java = jdk; };
          lombok = prev.lombok.override { inherit jdk; };
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
              gcc
              gradle
              jdt-language-server
              jetbrains.idea-oss
              jdk
              maven
              ncurses
              patchelf
              zlib
              (pkgs.writeShellScriptBin "ide" "idea-oss &")
            ];
            shellHook =
              let
                loadLombok = "-javaagent:${pkgs.lombok}/share/java/lombok.jar";
                prev = "\${JAVA_TOOL_OPTIONS:+ $JAVA_TOOL_OPTIONS}";
              in
              ''
                export JAVA_TOOL_OPTIONS="${loadLombok}${prev}"
              '';
          };
        }
      );
    };
}
