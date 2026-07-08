#version 150


#moj_import <minecraft:fog.glsl>
#moj_import <minecraft:dynamictransforms.glsl>
#moj_import <minecraft:globals.glsl>
#moj_import <minecraft:projection.glsl>

in vec3 Position;
in vec2 UV0;
in vec4 Color;

uniform sampler2D Sampler0;


out vec2 texCoord0;
out vec4 vertexColor;

vec2[] corners = vec2[](vec2(0, 0), vec2(0, 1), vec2(1, 1), vec2(1, 0));
vec2 screen = 2 / vec2(ProjMat[0][0], -ProjMat[1][1]);
float margin = 1;

bool posCheckX(float offset,float size) {
    return ( abs( (round(screen.x/2)+offset+(size*corners[gl_VertexID % 4].x)) - Position.x )<= margin );
}
bool posCheckY(float offset,float size) {
    return ( abs( (round(screen.y/2)+offset+(size*corners[gl_VertexID % 4].y)) - Position.y )<= margin );
}
bool posCheck(vec2 offset,vec2 size) {
    return ( abs( (round(screen.x/2)+offset.x+(size.x*corners[gl_VertexID % 4].x)) - Position.x )<= margin )&&
           ( abs( (round(screen.y/2)+offset.y+(size.y*corners[gl_VertexID % 4].y)) - Position.y )<= margin );
}
bool posCheck(vec2 offset,float size) {
    return posCheck(offset,vec2(size));
}


void main() {

    //====== Normal shader
    texCoord0 = UV0;
    vertexColor = Color; // 1.21
    //====================

    vec3 pos = Position;
    int vertID = gl_VertexID % 4;

    vec2 corner = corners[vertID];
    vec4 color = round(texture(Sampler0, texCoord0-(0.00001*corner))*255);


    if(color.a == 2){ //Custom SPRITES

        if(color.g == 1){ // BEACON 

            if(color.b == 1){// Beacon icons

                texCoord0.x -= (18.0/textureSize(Sampler0,0).x)*corner.x;

                if((posCheckX(-60,18)) || (posCheckX(-48,18)) || (posCheckX(-36,18)) || (posCheckX( 31,18))) pos = vec3(0,0,0);
                if (posCheckX(55,18)) texCoord0.x += 18.0/textureSize(Sampler0,0).x;
            }

            else if(color.b == 2){ // Beacon buttons

                pos.xy += ((corner-0.5)*2*3);
                texCoord0 -= corner*(56.0/textureSize(Sampler0,0));      // speed (default)

                 if(posCheck(vec2(-38,-88),22)) texCoord0 += vec2(28, 0)/textureSize(Sampler0,0); // haste
            else if(posCheck(vec2(-62,-63),22)) texCoord0 += vec2( 0,28)/textureSize(Sampler0,0); // resistance
            else if(posCheck(vec2(-38,-63),22)) texCoord0 += vec2(28,28)/textureSize(Sampler0,0); // jump boost
            else if(posCheck(vec2(-50,-38),22)) texCoord0 += vec2( 0,56)/textureSize(Sampler0,0); // strength
            else if(posCheck(vec2( 29,-63),22)) texCoord0 += vec2(56, 0)/textureSize(Sampler0,0); // regen
            else if(posCheck(vec2( 49, -3),22)) texCoord0 += vec2(28,56)/textureSize(Sampler0,0); // tier 2
            else if(posCheck(vec2( 53,-63),22)) texCoord0 += vec2(56,28)/textureSize(Sampler0,0); // beacon on
            else if(posCheck(vec2( 75, -3),22)) texCoord0 += vec2(56,56)/textureSize(Sampler0,0); // cross button
            }
        }
        else if(color.g == 2){ //SLOT

            if(color.b == 1){// Enchanting table lapis lazuli
                if(posCheckX(-53,16)) pos = vec3(0,0,0);
            }

            else if(color.b == 2){// Smithing table armour
                texCoord0.x -= (16.0/textureSize(Sampler0,0).x)*corner.x;
                if (posCheckX(-62,16)) texCoord0.x += 16.0/textureSize(Sampler0,0).x;
            }
        }
        else if(color.g == 3){ //Crafter
            pos.xy += (corner*158);
            pos.x -= 96.0;
            pos.y -= 34.0;
        }
        else if(color.g == 4){ //Anvil
            pos.xy += ((corner)*vec2(11,0));
            pos.x -= 11;
            pos.y += 1;
        }
        else if(color.g == 5){ //Villager
            pos.xy += ((corner)*vec2(78,11));
            pos.x -= 55;
            pos.y -= 4;
        }
        else if(color.g == 6){ //Recipe book button
            pos.xy += ((corner)*vec2(1, 3));
            texCoord0.x -= (21.0/textureSize(Sampler0,0).x)*corner.x;
            if (posCheckX(9,21) || posCheckX(93,21) || posCheckX(-6,21)) texCoord0.x += 21.0/textureSize(Sampler0,0).x;
            pos.y -= 6;
        }
    }
    gl_Position = ProjMat * ModelViewMat * vec4(pos, 1.0);
}