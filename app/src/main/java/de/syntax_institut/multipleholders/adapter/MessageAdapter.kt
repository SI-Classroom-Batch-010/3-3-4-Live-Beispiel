package de.syntax_institut.multipleholders.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import de.syntax_institut.multipleholders.data.model.Message
import de.syntax_institut.multipleholders.databinding.MessageItemReceiveBinding
import de.syntax_institut.multipleholders.databinding.MessageItemSendBinding

class MessageAdapter(val dataSet : List<Message>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val ITEM_TYPE_SEND = 0
    private val ITEM_TYPE_RECEIVE = 1

    class MessageSendViewHolder(val binding : MessageItemSendBinding) : ViewHolder(binding.root)

    class MessageReceiveViewHolder(val binding: MessageItemReceiveBinding) : ViewHolder(binding.root)

    override fun getItemViewType(position: Int): Int {
        val message = dataSet[position]
        return if(message.isSendByMe) ITEM_TYPE_SEND else ITEM_TYPE_RECEIVE
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if(viewType == ITEM_TYPE_SEND) {
            val binding = MessageItemSendBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return MessageSendViewHolder(binding)
        } else {
            val binding = MessageItemReceiveBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return MessageReceiveViewHolder(binding)
        }
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val message = dataSet[position]
        if(holder is MessageSendViewHolder) {
            holder.binding.tvMessageText.text = message.content
            holder.binding.tvMessageTime.text = message.time
        } else if(holder is MessageReceiveViewHolder) {
            holder.binding.tvMessageText.text = message.content
            holder.binding.tvMessageTime.text = message.time
        }
    }

}