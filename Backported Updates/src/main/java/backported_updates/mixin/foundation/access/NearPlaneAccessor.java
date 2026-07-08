package backported_updates.mixin.foundation.access;

import org.joml.Vector3f;
import net.minecraft.client.render.Camera;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

// Camera.Projection is a sealed interface in 1.21.1 with no fields.
// Exposing the Camera's horizontalPlane (forward direction vector) instead.
@Mixin(value={Camera.class})
public interface NearPlaneAccessor {
    @Accessor
    public Vector3f getHorizontalPlane();
}

