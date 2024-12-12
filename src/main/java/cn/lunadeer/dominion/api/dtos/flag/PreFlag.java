package cn.lunadeer.dominion.api.dtos.flag;

import org.jetbrains.annotations.NotNull;

public class PreFlag extends Flag {

    public PreFlag(@NotNull String flag_name, @NotNull String display_name, @NotNull String description, @NotNull Boolean default_value, @NotNull Boolean enable) {
        super(flag_name, display_name, description, default_value, enable);
    }

    @Override
    public String getConfigurationDescKey() {
        return "privilege." + getFlagName() + ".description";
    }

    @Override
    public String getConfigurationDefaultKey() {
        return "privilege." + getFlagName() + ".default";
    }

    @Override
    public String getConfigurationEnableKey() {
        return "privilege." + getFlagName() + ".enable";
    }

}
