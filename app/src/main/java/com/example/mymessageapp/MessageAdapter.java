package com.example.mymessageapp;

import android.media.Image;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.MessageHolder>{

    private List<Message> messageList;
    // Provide a suitable constructor (depends on the kind of dataset)
    public MessageAdapter(List<Message> messageList) {
        this.messageList = messageList;
    }

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class MessageHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public ImageView profileView;
        public TextView senderName;
        public TextView timeSent;
        public TextView messagePreview;

        public MessageHolder(RelativeLayout v) {
            super(v);
            profileView = v.findViewById(R.id.profile_image_view);
            senderName = v.findViewById(R.id.sender_name_text_view);
            timeSent = v.findViewById(R.id.time_sent);
            messagePreview = v.findViewById(R.id.mesage_preview);
        }
    }
    @NonNull
    @Override
    public MessageAdapter.MessageHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // create a new view
        RelativeLayout v = (RelativeLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_message, parent, false);
        return new MessageHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MessageAdapter.MessageHolder holder, int position) {
        holder.senderName.setText(messageList.get(position).senderName);
        holder.timeSent.setText(messageList.get(position).timeSent);
        holder.messagePreview.setText(messageList.get(position).messagePreview);
    }

    @Override
    public int getItemCount() {
        return messageList.size();
    }
}
