package cn.lunadeer.dominion.api.dtos.flag;

import org.jetbrains.annotations.NotNull;

import java.util.Map;

import static cn.lunadeer.dominion.api.DominionAPI.defaultPermission;

/**
 * Represents a flag in the Dominion system.
 * This abstract class provides the basic structure and methods
 * for flags, including their name, display name, description,
 * default value, and enable status.
 */
public abstract class Flag {

    public enum ENABLE_STATUS {
        TRUE,
        FALSE,
        DYNAMIC, // Dynamic means enabled but editability depends on permission
        ;

        public static ENABLE_STATUS fromString(String status) {
            if (status == null) {
                return ENABLE_STATUS.FALSE;
            }
            return switch (status.toLowerCase()) {
                case "true" -> ENABLE_STATUS.TRUE;
                case "false" -> ENABLE_STATUS.FALSE;
                case "dynamic" -> ENABLE_STATUS.DYNAMIC;
                default -> ENABLE_STATUS.FALSE; // Default to FALSE if unrecognized
            };
        }

        public static ENABLE_STATUS fromBoolean(Boolean status) {
            if (status == null) {
                return ENABLE_STATUS.FALSE;
            }
            return status ? ENABLE_STATUS.TRUE : ENABLE_STATUS.FALSE;
        }
    }

    private final String flag_name;
    private String display_name;
    private String description;
    private Boolean default_value;
    private ENABLE_STATUS enable;

    /**
     * Constructs a new Flag with the specified parameters.
     *
     * @param flag_name     the name of the flag
     * @param display_name  the display name of the flag
     * @param description   the description of the flag
     * @param default_value the default value of the flag
     * @param enable        the enable status of the flag
     */
    public Flag(@NotNull String flag_name, @NotNull String display_name, @NotNull String description, @NotNull Boolean default_value, @NotNull Boolean enable) {
        this.flag_name = flag_name;
        this.display_name = display_name;
        this.description = description;
        this.default_value = default_value;
        this.enable = ENABLE_STATUS.fromBoolean(enable);
    }

    /**
     * Returns the name of the flag.
     *
     * @return the name of the flag
     */
    public @NotNull String getFlagName() {
        return flag_name;
    }

    /**
     * Returns the display name of the flag.
     * This is the name that will be displayed to the user.
     * Can be translated in language files.
     *
     * @return the display name of the flag
     */
    public @NotNull String getDisplayName() {
        return display_name;
    }

    /**
     * Returns the description of the flag.
     * Can be translated in language files.
     *
     * @return the description of the flag
     */
    public @NotNull String getDescription() {
        return description;
    }

    /**
     * Returns the default value of the flag.
     *
     * @return the default value of the flag
     */
    public @NotNull Boolean getDefaultValue() {
        return default_value;
    }

    /**
     * Returns the enable status of the flag.
     *
     * @return the enable status of the flag
     */
    public @NotNull Boolean getEnable() {
        return switch (enable) {
            // Dynamic means enabled but editability depends on permission
            case TRUE, DYNAMIC -> true;
            case FALSE -> false;
        };
    }

    /**
     * Sets the display name of the flag.
     *
     * @param displayName the new display name of the flag
     */
    public void setDisplayName(String displayName) {
        this.display_name = displayName;
    }

    /**
     * Sets the description of the flag.
     *
     * @param description the new description of the flag
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Sets the default value of the flag.
     *
     * @param defaultValue the new default value of the flag
     */
    public void setDefaultValue(Boolean defaultValue) {
        this.default_value = defaultValue;
    }

    /**
     * Sets the enable status of the flag.
     *
     * @param enable the new enable status of the flag
     */
    public void setEnable(String enable) {
        this.enable = ENABLE_STATUS.fromString(enable);
    }

    /**
     * Returns the configuration key for the display name of the flag.
     *
     * @return the configuration key for the display name
     */
    public String getDisplayNameKey() {
        return "flags." + flag_name + ".display-name";
    }

    /**
     * Returns the configuration key for the description of the flag.
     *
     * @return the configuration key for the description
     */
    public String getDescriptionKey() {
        return "flags." + flag_name + ".description";
    }

    /**
     * Returns the configuration key for the description of this flag.
     *
     * @return the configuration key for the description
     */
    public abstract String getConfigurationDescKey();

    /**
     * Returns the configuration key for the default value of this flag.
     *
     * @return the configuration key for the default value
     */
    public abstract String getConfigurationDefaultKey();

    /**
     * Returns the configuration key for the enable status of this flag.
     *
     * @return the configuration key for the enable status
     */
    public abstract String getConfigurationEnableKey();

    /**
     * Returns the configuration key for the name of this flag.
     *
     * @return the configuration key for the name
     */
    public abstract String getConfigurationNameKey();

    /**
     * Abstract method to retrieve the permission node name for this flag.
     * This method should be implemented by subclasses to provide the specific
     * permission node name associated with the flag.
     *
     * @return the permission node name as a String
     */
    public abstract String getPermissionNodeName();

    /**
     * Retrieves the permission node configuration for this flag.
     * The configuration is represented as a map containing:
     * - "description": the description of the flag
     * - "default": the enable status of the flag as a String
     *
     * @return a Map containing the permission node configuration
     */
    public Map<String, Object> getPermissionNodeConfiguration() {
        return Map.of(
                "description", getDescription(),
                "default", "op"
        );
    }

    public Boolean isDynamic() {
        return enable == ENABLE_STATUS.DYNAMIC;
    }

    public String needPermissionNode() {
        return isDynamic() ? getPermissionNodeName() : defaultPermission;
    }

}