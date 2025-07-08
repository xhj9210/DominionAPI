package cn.lunadeer.dominion.api.dtos.flag;

import org.bukkit.Material;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Flags {
    // ================================== ENV
    public static final EnvFlag ANIMAL_SPAWN
            = new EnvFlag("animal_spawn", "动物生成（繁殖）", "是否允许动物生成（包括繁殖）", true, false, Material.COW_SPAWN_EGG);
    public static final EnvFlag ANIMAL_MOVE
            = new EnvFlag("animal_move", "动物移动", "是否允许动物在（向）领地内移动", true, false, Material.CHERRY_FENCE);
    public static final EnvFlag CREEPER_EXPLODE
            = new EnvFlag("creeper_explode", "生物破坏/非TNT爆炸", "包含：苦力怕/凋零头颅/末影水晶/火球/床/重生锚爆炸等", false, true, Material.CREEPER_HEAD);
    public static final EnvFlag DRAGON_BREAK_BLOCK
            = new EnvFlag("dragon_break_block", "末影龙破坏方块", "末影龙冲撞是否可以破坏方块", false, true, Material.ENDER_DRAGON_SPAWN_EGG);
    public static final EnvFlag ENDER_MAN
            = new EnvFlag("ender_man", "末影人行为", "包含：末影人是否可以生成、瞬移", false, true, Material.ENDERMAN_SPAWN_EGG);
    public static final EnvFlag FIRE_SPREAD
            = new EnvFlag("fire_spread", "火焰蔓延", "是否可以火焰蔓延", false, true, Material.CAMPFIRE);
    public static final EnvFlag FLOW_IN_PROTECTION
            = new EnvFlag("flow_in_protection", "外部流体是否可以进入", "包含：岩浆、水（不会阻止领地内部的流体蔓延）", false, true, Material.WATER_BUCKET);
    public static final EnvFlag GRAVITY_BLOCK
            = new EnvFlag("gravity_block", "允许外部重力方块落入", "如果禁止则领地外重力方块进入领地会变为掉落物", false, true, Material.SAND);
    public static final EnvFlag HOPPER_OUTSIDE
            = new EnvFlag("hopper_outside", "领地外漏斗对领地内箱子是否生效", "领地外的漏斗是否可以对领地内的箱子生效", false, true, Material.HOPPER);
    public static final EnvFlag ICE_MELT
            = new EnvFlag("ice_melt", "冰融化", "是否允许冰融化", false, false, Material.ICE);
    public static final EnvFlag ICE_FORM
            = new EnvFlag("ice_form", "冰生成", "是否允许冰生成（防止冰霜行者）", false, true, Material.PACKED_ICE);
    public static final EnvFlag ITEM_FRAME_PROJ_DAMAGE
            = new EnvFlag("item_frame_proj_damage", "投掷物是否可以破坏展示框/画", "非玩家发出的投掷物是否可以破坏展示框/画等悬挂物", false, true, Material.ITEM_FRAME);
    public static final EnvFlag MOB_DROP_ITEM
            = new EnvFlag("mob_drop_item", "生物战利品掉落", "生物死亡时是否产生掉落物", true, true, Material.DIAMOND);
    public static final EnvFlag MONSTER_SPAWN
            = new EnvFlag("monster_spawn", "怪物生成", "是否可以生成怪物", false, false, Material.ZOMBIE_SPAWN_EGG);
    public static final EnvFlag MONSTER_MOVE
            = new EnvFlag("monster_move", "怪物移动", "是否可以在（向）领地内移动", true, false, Material.CRIMSON_FENCE);
    public static final EnvFlag MONSTER_DAMAGE
            = new EnvFlag("monster_damage", "怪物对玩家造成伤害", "是否可以对玩家造成伤害", true, false, Material.SKELETON_SPAWN_EGG);
    public static final EnvFlag PISTON_OUTSIDE
            = new EnvFlag("piston_outside", "活塞是否可以跨领地推动方块", "活塞是否可以往领地内推东西或推东西到领地外", false, true, Material.PISTON);
    public static final EnvFlag SHOW_BORDER
            = new EnvFlag("show_border", "显示领地边界", "是否显示领地边界", true, true, Material.BARRIER);
    public static final EnvFlag SNOW_ACCUMULATION
            = new EnvFlag("snow_accumulation", "积雪", "是否允许生成积雪", false, false, Material.SNOW);
    public static final EnvFlag SNOW_MELT
            = new EnvFlag("snow_melt", "积雪融化", "是否允许积雪融化", false, false, Material.SNOW_BLOCK);
    public static final EnvFlag TNT_EXPLODE
            = new EnvFlag("tnt_explode", "TNT爆炸", "TNT是否可以爆炸", false, true, Material.TNT);
    public static final EnvFlag TRAMPLE
            = new EnvFlag("trample", "作物践踏", "是否可以践踏作物（关闭意味着保护耕地）", false, true, Material.FARMLAND);
    public static final EnvFlag TRIG_PRESSURE_PROJ
            = new EnvFlag("trig_pressure_proj", "投掷物触发压力板", "投掷物（箭/风弹/雪球）是否可以触发压力板", false, true, Material.BIRCH_PRESSURE_PLATE);
    public static final EnvFlag TRIG_PRESSURE_MOB
            = new EnvFlag("trig_pressure_mob", "生物触发压力板", "生物（不包含玩家）是否可以触发压力板", false, true, Material.HEAVY_WEIGHTED_PRESSURE_PLATE);
    public static final EnvFlag TRIG_PRESSURE_DROP
            = new EnvFlag("trig_pressure_drop", "掉落物触发压力板", "掉落物是否可以触发压力板", false, true, Material.LIGHT_WEIGHTED_PRESSURE_PLATE);
    public static final EnvFlag VILLAGER_SPAWN
            = new EnvFlag("villager_spawn", "村民繁殖", "是否允许村民繁殖（包括村民蛋）", true, false, Material.VILLAGER_SPAWN_EGG);
    public static final EnvFlag WITHER_SPAWN
            = new EnvFlag("wither_spawn", "凋零生成", "凋零生成以及凋零生成时产生的爆炸", false, true, Material.WITHER_SKELETON_SKULL);

    // ================================== PRE
    public static final PriFlag ADMIN =
            new PriFlag("admin", "管理员", "管理领地内的其他成员权限", false, true, Material.NETHER_STAR);
    public static final PriFlag ANCHOR =
            new PriFlag("anchor", "重生锚", "是否允许设置/使用重生锚", false, true, Material.RESPAWN_ANCHOR);
    public static final PriFlag ANIMAL_KILLING =
            new PriFlag("animal_killing", "对动物造成伤害", "是否允许对动物造成伤害", false, true, Material.COOKED_BEEF);
    public static final PriFlag ANVIL =
            new PriFlag("anvil", "使用铁砧", "是否允许使用铁砧", false, true, Material.ANVIL);
    public static final PriFlag BEACON =
            new PriFlag("beacon", "信标交互", "是否允许与信标交互", false, true, Material.BEACON);
    public static final PriFlag BED =
            new PriFlag("bed", "床交互", "是否允许使用床睡觉或设置重生点", false, true, Material.RED_BED);
    public static final PriFlag BREW =
            new PriFlag("brew", "使用酿造台", "是否可以使用酿造台", false, true, Material.BREWING_STAND);
    public static final PriFlag BREAK_BLOCK =
            new PriFlag("break", "破坏方块", "是否可以破坏方块（包括：一般方块、展示框、盔甲架）", false, true, Material.IRON_PICKAXE);
    public static final PriFlag BUTTON =
            new PriFlag("button", "使用按钮", "是否可以使用各种材质的按钮", false, true, Material.STONE_BUTTON);
    public static final PriFlag CAKE =
            new PriFlag("cake", "吃蛋糕", "是否可以吃蛋糕", false, true, Material.CAKE);
    public static final PriFlag CONTAINER =
            new PriFlag("container", "一般容器", "包含：箱子/木桶/潜影盒/盔甲架/展示框", false, true, Material.CHEST);
    public static final PriFlag CRAFT =
            new PriFlag("craft", "使用工作台", "是否可以使用工作台", false, true, Material.CRAFTING_TABLE);
    public static final PriFlag CRAFTER =
            new PriFlag("crafter", "合成器", "是否可以修改自动合成器", false, true, Material.CRAFTING_TABLE);
    public static final PriFlag COMPARER =
            new PriFlag("comparer", "比较器交互", "是否可以修改比较器状态", false, true, Material.COMPARATOR);
    public static final PriFlag DOOR =
            new PriFlag("door", "门交互", "是否可以使用各种材质的门（包括活板门）", false, true, Material.OAK_DOOR);
    public static final PriFlag DRAGON_EGG =
            new PriFlag("dragon_egg", "触碰龙蛋", "是否可以触碰龙蛋", false, true, Material.DRAGON_EGG);
    public static final PriFlag DYE =
            new PriFlag("dye", "染色", "是否可以使用染料（对羊、狗项圈、猫项圈）染色", false, true, Material.LIGHT_BLUE_DYE);
    public static final PriFlag EDIT_SIGN =
            new PriFlag("edit_sign", "编辑告示牌", "是否可以编辑告示牌", false, true, Material.OAK_SIGN);
    public static final PriFlag EGG =
            new PriFlag("egg", "扔鸡蛋", "是否可以扔鸡蛋", false, true, Material.EGG);
    public static final PriFlag ENCHANT =
            new PriFlag("enchant", "使用附魔台", "是否可以使用附魔台", false, true, Material.ENCHANTING_TABLE);
    public static final PriFlag ENDER_PEARL =
            new PriFlag("ender_pearl", "投掷末影珍珠", "是否可以使用末影珍珠", false, true, Material.ENDER_PEARL);
    public static final PriFlag FEED =
            new PriFlag("feed", "喂养动物", "是否可以喂养动物", false, true, Material.WHEAT);
    public static final PriFlag FLY =
            new PriFlag("fly", "飞行", "不是翅鞘飞行，是类似于创造模式的飞行", false, false, Material.ELYTRA);
    public static final PriFlag GLOW =
            new PriFlag("glow", "玩家发光", "类似光灵箭的高亮效果", false, true, Material.SPECTRAL_ARROW);
    public static final PriFlag HARVEST =
            new PriFlag("harvest", "收获", "收获庄稼、作物", false, true, Material.WHEAT);
    public static final PriFlag HONEY =
            new PriFlag("honey", "蜂巢交互", "是否可以采蜂蜜", false, true, Material.HONEY_BOTTLE);
    public static final PriFlag HOOK =
            new PriFlag("hook", "使用钓钩", "是否可以使用钓钩", false, true, Material.FISHING_ROD);
    public static final PriFlag HOPPER =
            new PriFlag("hopper", "特殊容器", "包含：漏斗/熔炉/发射器/投掷器/高炉/烟熏炉", false, true, Material.HOPPER);
    public static final PriFlag IGNITE =
            new PriFlag("ignite", "点燃", "是否可以使用打火石点火", false, true, Material.FLINT_AND_STEEL);
    public static final PriFlag ITEM_FRAME_INTERACTIVE =
            new PriFlag("item_frame_interactive", "展示框交互", "是否可以与物品展示框交互（旋转展示框的东西）", false, true, Material.ITEM_FRAME);
    public static final PriFlag LEVER =
            new PriFlag("lever", "使用拉杆", "是否可以使用拉杆", false, true, Material.LEVER);
    public static final PriFlag MONSTER_KILLING =
            new PriFlag("monster_killing", "对怪物造成伤害", "玩家是否可以对怪物造成伤害", false, true, Material.IRON_SWORD);
    public static final PriFlag MOVE =
            new PriFlag("move", "移动", "是否可以移动", true, true, Material.LEATHER_BOOTS);
    public static final PriFlag NOTE_BLOCK =
            new PriFlag("note_block", "点击音符盒", "红石音乐或者某些红石机器会用到...", false, true, Material.NOTE_BLOCK);
    public static final PriFlag PLACE =
            new PriFlag("place", "放置方块", "是否可以放置方块（包括：一般方块、展示框、岩浆、水）", false, true, Material.GRASS_BLOCK);
    public static final PriFlag PRESSURE =
            new PriFlag("pressure", "压力板交互", "是否可以触发各种材质的压力板", false, true, Material.STONE_PRESSURE_PLATE);
    public static final PriFlag RIDING =
            new PriFlag("riding", "骑乘载具", "是否可以骑乘各种载具", false, true, Material.SADDLE);
    public static final PriFlag REPEATER =
            new PriFlag("repeater", "中继器交互", "是否可以与中继器交互", false, true, Material.REPEATER);
    public static final PriFlag SHEAR =
            new PriFlag("shear", "剪羊毛", "是否可以剪羊毛", false, true, Material.SHEARS);
    public static final PriFlag SHOOT =
            new PriFlag("shoot", "投掷型武器", "包括：射箭/雪球/三叉戟/风弹", false, true, Material.BOW);
    public static final PriFlag TELEPORT =
            new PriFlag("teleport", "领地传送", "是否开启领地传送", false, true, Material.ENDER_EYE);
    public static final PriFlag TRADE =
            new PriFlag("trade", "村民交易", "是否可以与村民交易", false, true, Material.EMERALD);
    public static final PriFlag VEHICLE_DESTROY =
            new PriFlag("vehicle_destroy", "破坏载具", "是否可以破坏载具（主要是矿车）", false, true, Material.IRON_AXE);
    public static final PriFlag VEHICLE_SPAWN =
            new PriFlag("vehicle_spawn", "生成载具", "是否可以生成载具（主要是矿车）", false, true, Material.MINECART);
    public static final PriFlag VILLAGER_KILLING =
            new PriFlag("villager_killing", "对村民造成伤害", "是否可以对村民造成伤害", false, true, Material.WOODEN_SWORD);
    public static final PriFlag PVP =
            new PriFlag("pvp", "玩家伤害", "玩家之间是否可以造成伤害", false, true, Material.DIAMOND_SWORD);

    private static final List<EnvFlag> env_flags = new ArrayList<>();
    private static final List<PriFlag> pri_flags = new ArrayList<>();
    private static final List<Flag> all_flags = new ArrayList<>();

    static {
        for (java.lang.reflect.Field field : Flags.class.getDeclaredFields()) {
            try {
                Object obj = field.get(null);
                if (obj instanceof Flag flag) {
                    all_flags.add(flag);
                    if (flag instanceof EnvFlag envFlag) {
                        env_flags.add(envFlag);
                    } else if (flag instanceof PriFlag priFlag) {
                        pri_flags.add(priFlag);
                    }
                }
            } catch (IllegalAccessException ignored) {
            }
        }
        Comparator<Object> comparator = Collator.getInstance(java.util.Locale.CHINA);
        env_flags.sort((o1, o2) -> comparator.compare(o1.getDisplayName(), o2.getDisplayName()));
        pri_flags.sort((o1, o2) -> comparator.compare(o1.getDisplayName(), o2.getDisplayName()));
        all_flags.sort((o1, o2) -> comparator.compare(o1.getDisplayName(), o2.getDisplayName()));
    }


    /**
     * Returns a list of all flags.
     *
     * @return a list of all flags
     */
    public static List<Flag> getAllFlags() {
        return all_flags;
    }

    /**
     * Returns a list of all environment flags.
     *
     * @return a list of all environment flags
     */
    public static List<EnvFlag> getAllEnvFlags() {
        return env_flags;
    }

    /**
     * Returns a list of all privilege flags.
     *
     * @return a list of all privilege flags
     */
    public static List<PriFlag> getAllPriFlags() {
        return pri_flags;
    }

    /**
     * Returns a list of enabled flags from the given list of flags.
     *
     * @param flags the list of flags to filter
     * @param <T>   the type of the flags
     * @return a list of enabled flags
     */
    private static <T extends Flag> List<T> getEnabledFlags(List<T> flags) {
        List<T> enabledFlags = new ArrayList<>();
        for (T flag : flags) {
            if (flag.getEnable()) {
                enabledFlags.add(flag);
            }
        }
        return enabledFlags;
    }

    /**
     * Returns a list of all enabled environment flags.
     *
     * @return a list of all enabled environment flags
     */
    public static List<EnvFlag> getAllEnvFlagsEnable() {
        return getEnabledFlags(env_flags);
    }

    /**
     * Returns a list of all enabled privilege flags.
     *
     * @return a list of all enabled privilege flags
     */
    public static List<PriFlag> getAllPriFlagsEnable() {
        return getEnabledFlags(pri_flags);
    }

    /**
     * Returns a list of all enabled flags.
     *
     * @return a list of all enabled flags
     */
    public static List<Flag> getAllFlagsEnable() {
        return getEnabledFlags(all_flags);
    }

    /**
     * Returns a flag by its name from the given list of flags.
     *
     * @param flags the list of flags to search
     * @param name  the name of the flag
     * @param <T>   the type of the flags
     * @return the flag with the given name, or null if not found
     */
    private static <T extends Flag> T getFlagByName(List<T> flags, String name) {
        for (T flag : flags) {
            if (flag.getFlagName().equals(name)) {
                return flag;
            }
        }
        return null;
    }

    /**
     * Returns a flag by its name from all flags.
     *
     * @param name the name of the flag
     * @return the flag with the given name, or null if not found
     */
    public static Flag getFlag(String name) {
        return getFlagByName(all_flags, name);
    }

    /**
     * Returns an environment flag by its name.
     *
     * @param name the name of the environment flag
     * @return the environment flag with the given name, or null if not found
     */
    public static EnvFlag getEnvFlag(String name) {
        return getFlagByName(env_flags, name);
    }

    /**
     * Returns a privilege flag by its name.
     *
     * @param name the name of the privilege flag
     * @return the privilege flag with the given name, or null if not found
     */
    public static PriFlag getPreFlag(String name) {
        return getFlagByName(pri_flags, name);
    }
}
