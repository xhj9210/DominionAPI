package cn.lunadeer.dominion.api.dtos.flag;

import cn.lunadeer.minecraftpluginutils.XLogger;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Flags {
    // ================================== ENV
    public static final EnvFlag ANIMAL_SPAWN
            = new EnvFlag("animal_spawn", "动物生成（繁殖）", "是否允许动物生成（包括繁殖）", true, false);
    public static final EnvFlag ANIMAL_MOVE
            = new EnvFlag("animal_move", "动物移动", "是否允许动物在（向）领地内移动", true, false);
    public static final EnvFlag CREEPER_EXPLODE
            = new EnvFlag("creeper_explode", "生物破坏/非TNT爆炸", "包含：苦力怕/凋零头颅/末影水晶/火球/床/重生锚爆炸等", false, true);
    public static final EnvFlag DRAGON_BREAK_BLOCK
            = new EnvFlag("dragon_break_block", "末影龙破坏方块", "末影龙冲撞是否可以破坏方块", false, true);
    public static final EnvFlag ENDER_MAN
            = new EnvFlag("ender_man", "末影人行为", "包含：末影人是否可以生成、瞬移", false, true);
    public static final EnvFlag FIRE_SPREAD
            = new EnvFlag("fire_spread", "火焰蔓延", "是否可以火焰蔓延", false, true);
    public static final EnvFlag FLOW_IN_PROTECTION
            = new EnvFlag("flow_in_protection", "外部流体是否可以进入", "包含：岩浆、水（不会阻止领地内部的流体蔓延）", false, true);
    public static final EnvFlag GRAVITY_BLOCK
            = new EnvFlag("gravity_block", "允许外部重力方块落入", "如果禁止则领地外重力方块进入领地会变为掉落物", false, true);
    public static final EnvFlag HOPPER_OUTSIDE
            = new EnvFlag("hopper_outside", "领地外漏斗对领地内箱子是否生效", "领地外的漏斗是否可以对领地内的箱子生效", false, true);
    public static final EnvFlag ITEM_FRAME_PROJ_DAMAGE
            = new EnvFlag("item_frame_proj_damage", "投掷物是否可以破坏展示框/画", "非玩家发出的投掷物是否可以破坏展示框/画等悬挂物", false, true);
    public static final EnvFlag MOB_DROP_ITEM =
            new EnvFlag("mob_drop_item", "生物战利品掉落", "生物死亡时是否产生掉落物", true, true);
    public static final EnvFlag MONSTER_SPAWN
            = new EnvFlag("monster_spawn", "怪物生成", "是否可以生成怪物", false, false);
    public static final EnvFlag MONSTER_MOVE
            = new EnvFlag("monster_move", "怪物移动", "是否可以在（向）领地内移动", true, false);
    public static final EnvFlag PISTON_OUTSIDE =
            new EnvFlag("piston_outside", "活塞是否可以跨领地推动方块", "活塞是否可以往领地内推东西或推东西到领地外", false, true);
    public static final EnvFlag SHOW_BORDER
            = new EnvFlag("show_border", "显示领地边界", "是否显示领地边界", true, true);
    public static final EnvFlag TNT_EXPLODE
            = new EnvFlag("tnt_explode", "TNT爆炸", "TNT是否可以爆炸", false, true);
    public static final EnvFlag TRAMPLE
            = new EnvFlag("trample", "作物践踏", "是否可以践踏作物（关闭意味着保护耕地）", false, true);
    public static final EnvFlag TRIG_PRESSURE_PROJ
            = new EnvFlag("trig_pressure_proj", "投掷物触发压力板", "投掷物（箭/风弹/雪球）是否可以触发压力板", false, true);
    public static final EnvFlag TRIG_PRESSURE_MOB
            = new EnvFlag("trig_pressure_mob", "生物触发压力板", "生物（不包含玩家）是否可以触发压力板", false, true);
    public static final EnvFlag TRIG_PRESSURE_DROP
            = new EnvFlag("trig_pressure_drop", "掉落物触发压力板", "掉落物是否可以触发压力板", false, true);
    public static final EnvFlag VILLAGER_SPAWN
            = new EnvFlag("villager_spawn", "村民繁殖", "是否允许村民繁殖（包括村民蛋）", true, false);
    public static final EnvFlag WITHER_SPAWN
            = new EnvFlag("wither_spawn", "凋零生成", "凋零生成以及凋零生成时产生的爆炸", false, true);

    // ================================== PRE
    public static final PreFlag ADMIN
            = new PreFlag("admin", "管理员", "管理领地内的其他成员权限", false, true);
    public static final PreFlag ANCHOR
            = new PreFlag("anchor", "重生锚", "是否允许设置/使用重生锚", false, true);
    public static final PreFlag ANIMAL_KILLING
            = new PreFlag("animal_killing", "对动物造成伤害", "是否允许对动物造成伤害", false, true);
    public static final PreFlag ANVIL
            = new PreFlag("anvil", "使用铁砧", "是否允许使用铁砧", false, true);
    public static final PreFlag BEACON =
            new PreFlag("beacon", "信标交互", "是否允许与信标交互", false, true);
    public static final PreFlag BED =
            new PreFlag("bed", "床交互", "是否允许使用床睡觉或设置重生点", false, true);
    public static final PreFlag BREW =
            new PreFlag("brew", "使用酿造台", "是否可以使用酿造台", false, true);
    public static final PreFlag BREAK_BLOCK =
            new PreFlag("break", "破坏方块", "是否可以破坏方块（包括：一般方块、展示框、盔甲架）", false, true);
    public static final PreFlag BUTTON =
            new PreFlag("button", "使用按钮", "是否可以使用各种材质的按钮", false, true);
    public static final PreFlag CAKE =
            new PreFlag("cake", "吃蛋糕", "是否可以吃蛋糕", false, true);
    public static final PreFlag CONTAINER =
            new PreFlag("container", "一般容器", "包含：箱子/木桶/潜影盒/盔甲架/展示框", false, true);
    public static final PreFlag CRAFT =
            new PreFlag("craft", "使用工作台", "是否可以使用工作台", false, true);
    public static final PreFlag CRAFTER =
            new PreFlag("crafter", "合成器", "是否可以修改自动合成器", false, true);
    public static final PreFlag COMPARER =
            new PreFlag("comparer", "比较器交互", "是否可以修改比较器状态", false, true);
    public static final PreFlag DOOR =
            new PreFlag("door", "门交互", "是否可以使用各种材质的门（包括活板门）", false, true);
    public static final PreFlag DRAGON_EGG =
            new PreFlag("dragon_egg", "触碰龙蛋", "是否可以触碰龙蛋", false, true);
    public static final PreFlag DYE =
            new PreFlag("dye", "染色", "是否可以使用染料（对羊、狗项圈、猫项圈）染色", false, true);
    public static final PreFlag EDIT_SIGN =
            new PreFlag("edit_sign", "编辑告示牌", "是否可以编辑告示牌", false, true);
    public static final PreFlag EGG =
            new PreFlag("egg", "扔鸡蛋", "是否可以扔鸡蛋", false, true);
    public static final PreFlag ENCHANT =
            new PreFlag("enchant", "使用附魔台", "是否可以使用附魔台", false, true);
    public static final PreFlag ENDER_PEARL =
            new PreFlag("ender_pearl", "投掷末影珍珠", "是否可以使用末影珍珠", false, true);
    public static final PreFlag FEED =
            new PreFlag("feed", "喂养动物", "是否可以喂养动物", false, true);
    public static final PreFlag FLY =
            new PreFlag("fly", "飞行", "不是翅鞘飞行，是类似于创造模式的飞行", false, false);
    public static final PreFlag GLOW =
            new PreFlag("glow", "玩家发光", "类似光灵箭的高亮效果", false, true);
    public static final PreFlag HARVEST =
            new PreFlag("harvest", "收获", "收获庄稼、作物", false, true);
    public static final PreFlag HONEY =
            new PreFlag("honey", "蜂巢交互", "是否可以采蜂蜜", false, true);
    public static final PreFlag HOOK =
            new PreFlag("hook", "使用钓钩", "是否可以使用钓钩", false, true);
    public static final PreFlag HOPPER =
            new PreFlag("hopper", "特殊容器", "包含：漏斗/熔炉/发射器/投掷器/高炉/烟熏炉", false, true);
    public static final PreFlag IGNITE =
            new PreFlag("ignite", "点燃", "是否可以使用打火石点火", false, true);
    public static final PreFlag ITEM_FRAME_INTERACTIVE =
            new PreFlag("item_frame_interactive", "展示框交互", "是否可以与物品展示框交互（旋转展示框的东西）", false, true);
    public static final PreFlag LEVER =
            new PreFlag("lever", "使用拉杆", "是否可以使用拉杆", false, true);
    public static final PreFlag MONSTER_KILLING =
            new PreFlag("monster_killing", "对怪物造成伤害", "玩家是否可以对怪物造成伤害", false, true);
    public static final PreFlag MOVE =
            new PreFlag("move", "移动", "是否可以移动", true, true);
    public static final PreFlag NOTE_BLOCK =
            new PreFlag("note_block", "点击音符盒", "红石音乐或者某些红石机器会用到...", false, true);
    public static final PreFlag PLACE =
            new PreFlag("place", "放置方块", "是否可以放置方块（包括：一般方块、展示框、岩浆、水）", false, true);
    public static final PreFlag PRESSURE =
            new PreFlag("pressure", "压力板交互", "是否可以触发各种材质的压力板", false, true);
    public static final PreFlag RIDING =
            new PreFlag("riding", "骑乘载具", "是否可以骑乘各种载具", false, true);
    public static final PreFlag REPEATER =
            new PreFlag("repeater", "中继器交互", "是否可以与中继器交互", false, true);
    public static final PreFlag SHEAR =
            new PreFlag("shear", "剪羊毛", "是否可以剪羊毛", false, true);
    public static final PreFlag SHOOT =
            new PreFlag("shoot", "投掷型武器", "包括：射箭/雪球/三叉戟/风弹", false, true);
    public static final PreFlag TELEPORT =
            new PreFlag("teleport", "领地传送", "是否开启领地传送", false, true);
    public static final PreFlag TRADE =
            new PreFlag("trade", "村民交易", "是否可以与村民交易", false, true);
    public static final PreFlag VEHICLE_DESTROY =
            new PreFlag("vehicle_destroy", "破坏载具", "是否可以破坏载具（主要是矿车）", false, true);
    public static final PreFlag VEHICLE_SPAWN =
            new PreFlag("vehicle_spawn", "生成载具", "是否可以生成载具（主要是矿车）", false, true);
    public static final PreFlag VILLAGER_KILLING =
            new PreFlag("villager_killing", "对村民造成伤害", "是否可以对村民造成伤害", false, true);


    private static final List<EnvFlag> env_flags = new ArrayList<>();
    private static final List<PreFlag> pre_flags = new ArrayList<>();
    private static final List<Flag> all_flags = new ArrayList<>();


    static {
        for (java.lang.reflect.Field field : Flags.class.getDeclaredFields()) {
            try {
                Object obj = field.get(null);
                if (obj instanceof Flag flag) {
                    all_flags.add(flag);
                    if (flag instanceof EnvFlag envFlag) {
                        env_flags.add(envFlag);
                    } else if (flag instanceof PreFlag preFlag) {
                        pre_flags.add(preFlag);
                    }
                }
            } catch (IllegalAccessException e) {
                XLogger.err(e.getMessage());
            }
        }
        Comparator<Object> comparator = Collator.getInstance(java.util.Locale.CHINA);
        env_flags.sort((o1, o2) -> comparator.compare(o1.getDisplayName(), o2.getDisplayName()));
        pre_flags.sort((o1, o2) -> comparator.compare(o1.getDisplayName(), o2.getDisplayName()));
        all_flags.sort((o1, o2) -> comparator.compare(o1.getDisplayName(), o2.getDisplayName()));
    }

    /**
     * 获取所有 Flag 对象，包括 EnvFlag 和 PreFlag
     *
     * @return Flag 对象列表
     */
    public static List<Flag> getAllFlags() {
        return all_flags;
    }

    /**
     * 获取所有 EnvFlag 对象
     *
     * @return EnvFlag 对象列表
     */
    public static List<EnvFlag> getAllEnvFlags() {
        return env_flags;
    }

    /**
     * 获取所有 PreFlag 对象
     *
     * @return PreFlag 对象列表
     */
    public static List<PreFlag> getAllPreFlags() {
        return pre_flags;
    }

    /**
     * 获取所有启用的 Flag 对象
     *
     * @param flags Flag 对象列表
     * @param <T>   Flag 类型
     * @return 启用的 Flag 对象列表
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
     * 获取所有启用的 EnvFlag 对象
     *
     * @return 启用的 EnvFlag 对象列表
     */
    public static List<EnvFlag> getAllEnvFlagsEnable() {
        return getEnabledFlags(env_flags);
    }

    /**
     * 获取所有启用的 PreFlag 对象
     *
     * @return 启用的 PreFlag 对象列表
     */
    public static List<PreFlag> getAllPreFlagsEnable() {
        return getEnabledFlags(pre_flags);
    }

    /**
     * 获取所有启用的 Flag 对象
     *
     * @return 启用的 Flag 对象列表
     */
    public static List<Flag> getAllFlagsEnable() {
        return getEnabledFlags(all_flags);
    }

    /**
     * 根据名称获取 Flag 对象
     *
     * @param flags Flag 对象列表
     * @param name  Flag 名称
     * @param <T>   Flag 类型
     * @return Flag 对象
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
     * 根据名称获取 Flag 对象
     *
     * @param name Flag 名称
     * @return Flag 对象
     */
    public static Flag getFlag(String name) {
        return getFlagByName(all_flags, name);
    }

    /**
     * 根据名称获取 EnvFlag 对象
     *
     * @param name Flag 名称
     * @return EnvFlag 对象
     */
    public static EnvFlag getEnvFlag(String name) {
        return getFlagByName(env_flags, name);
    }

    /**
     * 根据名称获取 PreFlag 对象
     *
     * @param name Flag 名称
     * @return PreFlag 对象
     */
    public static PreFlag getPreFlag(String name) {
        return getFlagByName(pre_flags, name);
    }
}
