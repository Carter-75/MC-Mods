#version 150

#moj_import <fog.glsl>

uniform sampler2D Sampler0;

uniform vec4 ColorModulator;
uniform float FogStart;
uniform float FogEnd;
uniform vec4 FogColor;

in float vertexDistance;
in vec4 vertexColor;
in vec2 texCoord0;

in float interpFactor;
in vec2 texCoordNext;

out vec4 fragColor;

void main() {
    vec4 color = texture(Sampler0, texCoord0) * vertexColor * ColorModulator;
    if (color.a < 0.1) {
        discard;
    }

    if (color.r > 0.988 && color.r < 0.989
        && color.g > 0.988 && color.g < 0.989
        && color.b > 0.4 && color.b < 0.5) {
        color = vec4(0.404, 0.365, 0.286, 1.0);
    }
    fragColor = linear_fog(color, vertexDistance, FogStart, FogEnd, FogColor);

    vec4 col = texture(Sampler0, texCoord0);
    if (interpFactor > 0.0) {
        vec4 nextCol = texture(Sampler0, texCoordNext);
        col = mix(col, nextCol, interpFactor);
        fragColor = col * vertexColor;
    }
}
