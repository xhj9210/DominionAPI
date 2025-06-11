package cn.lunadeer.dominion.api.dtos.flag;

import org.jetbrains.annotations.NotNull;

/**
 * Represents an environment flag in the Dominion system.
 * This class extends the Flag class and provides specific
 * configuration keys for environment-related flags.
 */
public class EnvFlag extends Flag {

    /**
     * Constructs a new EnvFlag with the specified parameters.
     *
     * @param flag_name     the name of the flag
     * @param display_name  the display name of the flag
     * @param description   the description of the flag
     * @param default_value the default value of the flag
     * @param enable        the enable status of the flag
     */
    public EnvFlag(@NotNull String flag_name, @NotNull String display_name, @NotNull String description, @NotNull Boolean default_value, @NotNull Boolean enable) {
        super(flag_name, display_name, description, default_value, enable);
    }

    @Override
    public String getConfigurationDescKey() {
        return "environment." + getFlagName() + ".description";
    }

    @Override
    public String getConfigurationDefaultKey() {
        return "environment." + getFlagName() + ".default";
    }

    @Override
    public String getConfigurationEnableKey() {
        return "environment." + getFlagName() + ".enable";
    }

    @Override
    public String getConfigurationNameKey() {
        return "environment." + getFlagName();
    }

    @Override
    public String getPermissionNodeName() {
        return "dominion.flag.environment." + getFlagName();
    }

}