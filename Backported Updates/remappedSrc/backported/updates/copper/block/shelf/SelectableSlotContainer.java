/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2350
 *  net.minecraft.class_241
 *  net.minecraft.class_243
 *  net.minecraft.class_3532
 *  net.minecraft.class_3965
 */
package backported.updates.copper.block.shelf;

import java.util.Optional;
import java.util.OptionalInt;
import net.minecraft.class_2350;
import net.minecraft.class_241;
import net.minecraft.class_243;
import net.minecraft.class_3532;
import net.minecraft.class_3965;

public interface SelectableSlotContainer {
    public int getRows();

    public int getColumns();

    default public OptionalInt getHitSlot(class_3965 hitResult, class_2350 direction) {
        return SelectableSlotContainer.getRelativeHitCoordinatesForBlockFace(hitResult, direction).map(coords -> {
            int row = SelectableSlotContainer.getSection(1.0f - coords.field_1342, this.getRows());
            int col = SelectableSlotContainer.getSection(coords.field_1343, this.getColumns());
            return OptionalInt.of(col + row * this.getColumns());
        }).orElseGet(OptionalInt::empty);
    }

    private static Optional<class_241> getRelativeHitCoordinatesForBlockFace(class_3965 hitResult, class_2350 direction) {
        class_2350 hitDirection = hitResult.method_17780();
        if (direction != hitDirection) {
            return Optional.empty();
        }
        class_243 location = hitResult.method_17784();
        double x = location.method_10216() - (double)hitResult.method_17777().method_10263();
        double y = location.method_10214() - (double)hitResult.method_17777().method_10264();
        double z = location.method_10215() - (double)hitResult.method_17777().method_10260();
        return switch (direction) {
            default -> throw new MatchException(null, null);
            case class_2350.field_11043 -> Optional.of(new class_241((float)(1.0 - x), (float)y));
            case class_2350.field_11035 -> Optional.of(new class_241((float)x, (float)y));
            case class_2350.field_11039 -> Optional.of(new class_241((float)z, (float)y));
            case class_2350.field_11034 -> Optional.of(new class_241((float)(1.0 - z), (float)y));
            case class_2350.field_11033, class_2350.field_11036 -> Optional.empty();
        };
    }

    private static int getSection(float pos, int count) {
        float scaledPos = pos * 16.0f;
        float sectionSize = 16.0f / (float)count;
        return class_3532.method_15340((int)class_3532.method_15375((float)(scaledPos / sectionSize)), (int)0, (int)(count - 1));
    }
}

