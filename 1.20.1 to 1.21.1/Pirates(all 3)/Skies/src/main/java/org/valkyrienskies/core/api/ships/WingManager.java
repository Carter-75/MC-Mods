/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 */
package org.valkyrienskies.core.api.ships;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joml.Matrix4dc;
import org.valkyrienskies.core.api.ships.Wing;
import org.valkyrienskies.core.api.ships.WingManagerChanges;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u001d\u0010\t\u001a\u00060\u0007j\u0002`\b2\b\b\u0002\u0010\u0006\u001a\u00020\u0005H&\u00a2\u0006\u0004\b\t\u0010\nJ\u001b\u0010\f\u001a\u00020\u00052\n\u0010\u000b\u001a\u00060\u0007j\u0002`\bH&\u00a2\u0006\u0004\b\f\u0010\rJ\u0013\u0010\u000e\u001a\u00060\u0007j\u0002`\bH&\u00a2\u0006\u0004\b\u000e\u0010\u000fJ5\u0010\u0014\u001a\u0004\u0018\u00010\u00132\n\u0010\u000b\u001a\u00060\u0007j\u0002`\b2\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0007H&\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0011\u0010\u0017\u001a\u0004\u0018\u00010\u0016H&\u00a2\u0006\u0004\b\u0017\u0010\u0018J=\u0010\u001a\u001a\u00020\u00052\n\u0010\u000b\u001a\u00060\u0007j\u0002`\b2\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\u0013H&\u00a2\u0006\u0004\b\u001a\u0010\u001bJ#\u0010\u001e\u001a\u00020\u00022\n\u0010\u000b\u001a\u00060\u0007j\u0002`\b2\u0006\u0010\u001d\u001a\u00020\u001cH&\u00a2\u0006\u0004\b\u001e\u0010\u001f\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00a8\u0006 \u00c0\u0006\u0001"}, d2={"Lorg/valkyrienskies/core/api/ships/WingManager;", "", "", "clearWingChanges", "()V", "", "isContraption", "", "Lorg/valkyrienskies/core/api/ships/WingGroupId;", "createWingGroup", "(Z)I", "wingGroupId", "deleteWingGroup", "(I)Z", "getFirstWingGroupId", "()I", "posX", "posY", "posZ", "Lorg/valkyrienskies/core/api/ships/Wing;", "getWing", "(IIII)Lorg/valkyrienskies/core/api/ships/Wing;", "Lorg/valkyrienskies/core/api/ships/WingManagerChanges;", "getWingChanges", "()Lorg/valkyrienskies/core/api/ships/WingManagerChanges;", "wing", "setWing", "(IIIILorg/valkyrienskies/core/api/ships/Wing;)Z", "Lorg/joml/Matrix4dc;", "transform", "setWingGroupTransform", "(ILorg/joml/Matrix4dc;)V", "api"})
public interface WingManager {
    public int createWingGroup(boolean var1);

    public static /* synthetic */ int createWingGroup$default(WingManager wingManager, boolean bl, int n2, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createWingGroup");
        }
        if ((n2 & 1) != 0) {
            bl = false;
        }
        return wingManager.createWingGroup(bl);
    }

    public boolean deleteWingGroup(int var1);

    public boolean setWing(int var1, int var2, int var3, int var4, @Nullable Wing var5);

    @Nullable
    public Wing getWing(int var1, int var2, int var3, int var4);

    public void setWingGroupTransform(int var1, @NotNull Matrix4dc var2);

    @Nullable
    public WingManagerChanges getWingChanges();

    public void clearWingChanges();

    public int getFirstWingGroupId();
}

