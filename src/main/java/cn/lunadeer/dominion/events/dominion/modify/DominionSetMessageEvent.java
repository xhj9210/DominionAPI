package cn.lunadeer.dominion.events.dominion.modify;

import cn.lunadeer.dominion.api.dtos.DominionDTO;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

/**
 * 领地消息变更事件，当一个领地的消息被变更时触发。包含进入领地的提示消息和离开领地的提示消息。
 */
public class DominionSetMessageEvent extends DominionModifyEvent {

    /**
     * 领地消息变更类型
     */
    public enum TYPE {
        ENTER,   // 进入领地的提示消息
        LEAVE,  // 离开领地的提示消息
    }

    private final String oldMessage;
    private final TYPE type;
    private String newMessage;

    /**
     * 领地消息变更事件
     *
     * @param operator   操作者
     * @param dominion   领地
     * @param type       变更类型
     * @param newMessage 新消息
     */
    public DominionSetMessageEvent(@NotNull CommandSender operator,
                                   @NotNull DominionDTO dominion,
                                   @NotNull DominionSetMessageEvent.TYPE type,
                                   @NotNull String newMessage) {
        super(operator, dominion);
        this.oldMessage = type == TYPE.ENTER ? dominion.getJoinMessage() : dominion.getLeaveMessage();
        this.type = type;
        this.newMessage = newMessage;
    }

    /**
     * 获取旧消息内容。
     *
     * @return 旧消息内容
     */
    public @NotNull String getOldMessage() {
        return oldMessage;
    }

    /**
     * 获取消息变更类型。
     *
     * @return 消息变更类型
     */
    public @NotNull DominionSetMessageEvent.TYPE getType() {
        return type;
    }

    /**
     * 获取新消息内容。
     *
     * @return 新消息内容
     */
    public @NotNull String getNewMessage() {
        return newMessage;
    }

    /**
     * 设置新消息内容。
     * <p>
     * 在 {@link org.bukkit.event.EventPriority} 为 {@link org.bukkit.event.EventPriority#HIGH} 以及更高
     * 的 {@link org.bukkit.event.EventHandler} 中修改时无法生效。（默认为 {@link org.bukkit.event.EventPriority#NORMAL}）
     *
     * @param newMessage 新消息内容
     */
    public void setNewMessage(@NotNull String newMessage) {
        this.newMessage = newMessage;
    }
}
