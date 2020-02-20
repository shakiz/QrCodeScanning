package com.shakil.qrcodescanning.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.shakil.qrcodescanning.R;
import com.shakil.qrcodescanning.model.Ticket;
import java.util.ArrayList;

public class TicketLogListAdapter extends RecyclerView.Adapter<TicketLogListAdapter.ViewHolder> {

    private ArrayList<Ticket> ticketLogList;
    private Context context;

    public TicketLogListAdapter(ArrayList<Ticket> ticketLogList, Context context) {
        this.ticketLogList = ticketLogList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.adapter_recycler_ticket_log_list,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Ticket ticket = ticketLogList.get(position);
        holder.TicketNo.setText(ticket.getTicket_id());
        holder.ScanTime.setText(ticket.getScan_time());
        holder.Status.setText(ticket.getStatus());
        String status = ticket.getStatus();
        if (status.equals("valid")){
            holder.Status.setTextColor(context.getResources().getColor(R.color.md_green_400));
        }
        else if (status.equals("invalid")){
            holder.Status.setTextColor(context.getResources().getColor(R.color.md_red_400));
        }

    }

    @Override
    public int getItemCount() {
        return ticketLogList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView TicketNo , ScanTime , Status;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            TicketNo = itemView.findViewById(R.id.TicketNo);
            ScanTime = itemView.findViewById(R.id.ScanTime);
            Status = itemView.findViewById(R.id.Status);
        }
    }
}
