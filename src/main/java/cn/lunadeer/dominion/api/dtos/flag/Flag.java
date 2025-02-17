package cn.lunadeer.dominion.api.dtos.flag;

import org.jetbrains.annotations.NotNull;

public abstract class Flag {

    private final String flag_name;
    private String display_name;
    private String description;
    private Boolean default_value;
    private Boolean enable;

    public Flag(@NotNull String flag_name, @NotNull String display_name, @NotNull String description, @NotNull Boolean default_value, @NotNull Boolean enable) {
        this.flag_name = flag_name;
        this.display_name = display_name;
        this.description = description;
        this.default_value = default_value;
        this.enable = enable;
    }


    /**
     * 权限名称（英文）
     *
     * @return 权限名称
     */
    public @NotNull String getFlagName() {
        return flag_name;
    }

    /**
     * 权限显示名称（中文）
     * 该名称从languages文件中加载
     *
     * @return 权限显示名称
     */
    public @NotNull String getDisplayName() {
        return display_name;
    }

    /**
     * 权限描述
     * 该描述从languages文件中加载
     *
     * @return 权限描述
     */
    public @NotNull String getDescription() {
        return description;
    }

    /**
     * 获取权限默认值
     *
     * @return 权限默认值
     */
    public @NotNull Boolean getDefaultValue() {
        return default_value;
    }

    /**
     * 获取权限是否启用
     *
     * @return 权限是否启用
     */
    public @NotNull Boolean getEnable() {
        return enable;
    }

    public void setDisplayName(String displayName) {
        this.display_name = displayName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDefaultValue(Boolean defaultValue) {
        this.default_value = defaultValue;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public String getDisplayNameKey() {
        return "flags." + flag_name + ".display-name";
    }

    public String getDescriptionKey() {
        return "flags." + flag_name + ".description";
    }

    public abstract String getConfigurationDescKey();

    public abstract String getConfigurationDefaultKey();

    public abstract String getConfigurationEnableKey();

}
