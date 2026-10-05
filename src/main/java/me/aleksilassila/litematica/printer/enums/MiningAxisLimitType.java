package me.aleksilassila.litematica.printer.enums;

import me.aleksilassila.litematica.printer.I18n;
import me.aleksilassila.litematica.printer.config.ConfigOptionListEntry;
import net.minecraft.core.BlockPos;

public enum MiningAxisLimitType implements ConfigOptionListEntry<MiningAxisLimitType> {
    NONE("miningAxisLimit.none"),
    SAME_X("miningAxisLimit.sameX"),
    SAME_Z("miningAxisLimit.sameZ");

    private final I18n i18n;

    MiningAxisLimitType(String translateKey) {
        this.i18n = I18n.of(translateKey);
    }

    @Override
    public I18n getI18n() {
        return i18n;
    }

    public boolean matches(BlockPos pos, double playerX, double playerZ) {
        return switch (this) {
            case NONE -> true;
            case SAME_X -> pos.getX() == (int) Math.floor(playerX);
            case SAME_Z -> pos.getZ() == (int) Math.floor(playerZ);
        };
    }
}
