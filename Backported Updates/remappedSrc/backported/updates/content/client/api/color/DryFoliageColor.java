/*
 * Decompiled with CFR 0.152.
 */
package backported.updates.content.client.api.color;

public class DryFoliageColor {
    public static final int FOLIAGE_DRY_DEFAULT = -10732494;
    private static int[] pixels = new int[65536];

    public static void init(int[] colors) {
        pixels = colors;
    }

    public static int get(double temperature, double humidity) {
        return DryFoliageColor.get(temperature, humidity, pixels);
    }

    static int get(double temperature, double humidity, int[] pixels) {
        int humidityOffset = (int)((1.0 - (humidity *= temperature)) * 255.0);
        int tempOffset = (int)((1.0 - temperature) * 255.0);
        int index = humidityOffset << 8 | tempOffset;
        return index >= pixels.length ? -10732494 : pixels[index];
    }
}

