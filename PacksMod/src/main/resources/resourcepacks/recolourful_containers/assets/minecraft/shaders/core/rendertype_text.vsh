#version 150

#moj_import <fog.glsl>

in vec3 Position;
in vec4 Color;
in vec2 UV0;
in ivec2 UV2;

uniform sampler2D Sampler2;
uniform sampler2D Sampler0;

uniform mat4 ModelViewMat;
uniform mat4 ProjMat;
uniform mat3 IViewRotMat;
uniform int FogShape;
uniform float GameTime;

out float vertexDistance;
out vec4 vertexColor;
out vec2 texCoord0;

out float interpFactor;
out vec2 texCoordNext;

vec2[] corners = vec2[](vec2(0, 0), vec2(0, 1), vec2(1, 1), vec2(1, 0));

float margin = 0;
vec2 screen = 2 / vec2(ProjMat[0][0], -ProjMat[1][1]);


void animation(inout vec3 pos, vec2 corner, out float interpFactor, out vec2 texCoordNext, float animation_speed, float frames, float height, int initial_delay, bool interpolate) {
    float time = mod(GameTime * 24000.0, animation_speed + initial_delay);
    float current_tile = 0.0;

    float frame_progress = (time - initial_delay) / (animation_speed / frames);
    if (time >= initial_delay){
        current_tile = floor(frame_progress);
    }
    texCoord0.y -= (height*(frames-1)/textureSize(Sampler0,0).y)*corner.y;
    if (interpolate) {
        interpFactor = fract(frame_progress);
        texCoordNext = texCoord0 + vec2(0.0, height * mod(current_tile + 1.0, frames) / textureSize(Sampler0, 0).y);
    }
    pos.xy -= ((corner)*vec2(0, height*(frames-1)));
    texCoord0.y += height * current_tile / textureSize(Sampler0, 0).y;
}

void applyAnimation(inout vec3 pos, vec2 corner, float frames, float height, float current_tile) {
    texCoord0.y -= (height * (frames - 1.0) / textureSize(Sampler0, 0).y) * corner.y;
    pos.xy -= (corner * vec2(0.0, height * (frames - 1.0)));
    texCoord0.y += height * current_tile / textureSize(Sampler0, 0).y;
}

void main() {


    //====== Normal shader
    texCoord0 = UV0;
    vertexColor = Color; // 1.21
    //====================

    interpFactor = 0.0;
    texCoordNext = vec2(0, 0);

    vec3 pos = Position;
    int vertID = gl_VertexID % 4;

    vec4 textColor = Color;

    vec2 corner = corners[vertID];
    vec4 color = round(texture(Sampler0, texCoord0-(0.00001*corner))*255);


    if(color.a == 2){ //Custom SPRITES
        if (round(255*Color.r) != 64.0) pos = vec3(100000,0,0); // Remove if not in UI
        textColor = vec4(1);
        if(color.g == 1){// Shulker boxes
            pos.xy += ((corner)*vec2(176,88));
            pos.x -= 8;
            pos.y -= 13;
        }
        if(color.g == 2){// Villagers
            if(color.b == 12){// Villagers eye animations
                pos.x = screen.x/2 - 22;
                pos.xy += ((corner)*vec2(12,35));
                pos.y += 36;
                float animation_speed = 8;
                float frames = 7;
                float height = 5;

                const int total_frames = 9;
                const int frame_duration[total_frames] = int[]
                (100, 60, 60, 20, 2, 2, 2, 60, 40);
                const int frame_tile[total_frames] = int[]
                (0, 1, 0, 2, 4, 5, 6, 0, 3);

                float time = mod(GameTime * 24000.0, 346.0);
                float current_tile = 0.0;
                float new_time = 0.0;
                for (int i = 0; i < total_frames; i++) {
                    new_time += frame_duration[i];
                    if (time < new_time) {
                        current_tile = frame_tile[i];
                        break;
                    }
                }
                applyAnimation(pos, corner, frames, height, current_tile);
            }
            else{
                pos.x = screen.x/2 - 36;
                pos.xy += ((corner)*vec2(37.9,75.9));
                pos.y -= 12.9;
            }
        }
        if(color.b == 1){// Enchanting table Animations
            float animation_speed = 16;
            float frames = 8;
            float height = 16;

            animation(pos, corner, interpFactor, texCoordNext, animation_speed, frames, height, 0, false);

            pos.x += 7;
            pos.y += 34;
        }
        else if(color.b == 2){// Cartography table Animations
            float animation_speed = 8;
            float frames = 11;
            float height = 21;

            const int total_frames = 40;
            const int frame_duration[total_frames] = int[]
            (200, 1, 2, 3, 2, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 2, 3, 2, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 2, 1, 2, 2);
            const int frame_tile[total_frames] = int[]
            (0, 1, 2, 3, 2, 1, 0, 7, 8, 9, 10, 9, 8, 7, 0, 1, 2, 3, 4, 5, 6, 5, 4, 3, 2, 1, 0, 7, 8, 9, 10, 9, 8, 7, 0, 1, 2, 1, 0, 7);


            float time = mod(GameTime * 24000.0, 252.0);
            float current_tile = 0.0;
            float new_time = 0.0;
            for (int i = 0; i < total_frames; i++) {
                new_time += frame_duration[i];
                if (time < new_time) {
                    current_tile = frame_tile[i];
                    break;
                }
            }
            applyAnimation(pos, corner, frames, height, current_tile);

            pos.x += 140;
            pos.y -= 5;
        }
        else if(color.b == 3){// Ender chest Animations
            float animation_speed = 8;
            float frames = 9;
            float height = 10;

            const int total_frames = 12;
            const int frame_duration[total_frames] = int[]
            (20, 2, 10, 2, 1, 2, 10, 2, 2, 2, 120, 20);
            const int frame_tile[total_frames] = int[]
            (0, 3, 4, 3, 0, 5, 6, 7, 2, 1, 0, 8);

            float time = mod(GameTime * 24000.0, 193.0);
            float current_tile = 0.0;
            float new_time = 0.0;
            for (int i = 0; i < total_frames; i++) {
                new_time += frame_duration[i];
                if (time < new_time) {
                    current_tile = frame_tile[i];
                    break;
                }
            }
            applyAnimation(pos, corner, frames, height, current_tile);

            pos.x += 75;
            pos.y -= 7;
        }
        else if(color.b == 4){// Dropper redstone Animation
            float animation_speed = 56;
            float frames = 3;
            float height = 77;

            animation(pos, corner, interpFactor, texCoordNext, animation_speed, frames, height, 0, true);

            pos.x += 25;
            pos.y -= 13;
        }
        else if(color.b == 5){// Dropper piston_1 Animation
            float animation_speed = 8;
            float frames = 4;
            float height = 32;

            const int total_frames = 15;
            const int frame_duration[total_frames] = int[]
            (200, 1, 40, 1, 200, 20, 100, 1, 40, 1, 200, 1, 40, 1, 20);
            const int frame_tile[total_frames] = int[]
            (0, 1, 2, 1, 0, 3, 0, 1, 2, 1, 0, 1, 2, 1, 0);

            float time = mod(GameTime * 24000.0, 846.0);
            float current_tile = 0.0;
            float new_time = 0.0;
            for (int i = 0; i < total_frames; i++) {
                new_time += frame_duration[i];
                if (time < new_time) {
                    current_tile = frame_tile[i];
                    break;
                }
            }
            applyAnimation(pos, corner, frames, height, current_tile);

            pos.x -= 20;
            pos.y += 6;
        }
        else if(color.b == 6){ // Dropper piston_2 Animation
            float animation_speed = 8;
            float frames = 3;
            float height = 16;

            const int total_frames = 15;
            const int frame_duration[total_frames] = int[]
            (204, 1, 40, 1, 200, 20, 100, 1, 40, 1, 200, 1, 40, 1, 16);
            const int frame_tile[total_frames] = int[]
            (0, 1, 2, 1, 0, 0, 0, 1, 2, 1, 0, 1, 2, 1, 0);

            float time = mod(GameTime * 24000.0, 846.0);
            float current_tile = 0.0;
            float new_time = 0.0;
            for (int i = 0; i < total_frames; i++) {
                new_time += frame_duration[i];
                if (time < new_time) {
                    current_tile = frame_tile[i];
                    break;
                }
            }
            applyAnimation(pos, corner, frames, height, current_tile);

            pos.x -= 53;
            pos.y += 40;
        }
        else if(color.b == 7){// Dispenser redstone Animation
            float animation_speed = 56;
            float frames = 3;
            float height = 77;

            animation(pos, corner, interpFactor, texCoordNext, animation_speed, frames, height, 0, true);

            pos.x += 1;
            pos.y -= 13;
        }
        else if(color.b == 8){// Dispenser bow Animation
            float animation_speed = 8;
            float frames = 3;
            float height = 68;

            const int total_frames = 4;
            const int frame_duration[total_frames] = int[]
            (200, 2, 20, 2);
            const int frame_tile[total_frames] = int[]
            (0, 1, 2, 1);

            float time = mod(GameTime * 24000.0, 224.0);
            float current_tile = 0.0;
            float new_time = 0.0;
            for (int i = 0; i < total_frames; i++) {
                new_time += frame_duration[i];
                if (time < new_time) {
                    current_tile = frame_tile[i];
                    break;
                }
            }
            applyAnimation(pos, corner, frames, height, current_tile);

            pos.y -= 5;
        }
        else if(color.b == 9){// Anvil Animations
            float animation_speed = 8;
            float frames = 12;
            float height = 21;

            animation(pos, corner, interpFactor, texCoordNext, animation_speed, frames, height, 200, false);

            pos.x -= 35;
            pos.y -= 3;
        }
        else if(color.b == 10){// Smithing table Animations
            float animation_speed = 8;
            float frames = 12;
            float height = 21;

            animation(pos, corner, interpFactor, texCoordNext, animation_speed, frames, height, 200, false);

            pos.x -= 19;
            pos.y -= 15;
        }
        else if(color.b == 11){// Stonecutter Animation
            float animation_speed = 2;
            float frames = 2;
            float height = 67;

            if (mod((GameTime*24000), animation_speed) < animation_speed/frames) applyAnimation(pos, corner, frames, height, 0.0);
            else applyAnimation(pos, corner, frames, height, 1.0);

            pos.x -= 4;
            pos.y -= 12;
        }
    }

    //===================================== Normal shader
    vertexDistance = fog_distance(ModelViewMat, IViewRotMat * Position, FogShape);
    vertexColor = textColor * texelFetch(Sampler2, UV2 / 16, 0);
    gl_Position = ProjMat * ModelViewMat * vec4(pos, 1.0);
}