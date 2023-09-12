package com.subbaabhishek.callloggerassignment.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.subbaabhishek.callloggerassignment.R
import com.subbaabhishek.callloggerassignment.model.CallLog

class CallLogRecyclerAdapter(private val callLogList: List<CallLog>) : RecyclerView.Adapter<CallLogRecyclerAdapter.CallLogViewHolder>() {

    val callLogs: List<CallLog> = callLogList;

    class CallLogViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CallLogViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.call_log_item, parent, false)
        return CallLogViewHolder(view)
    }

    override fun getItemCount(): Int {
        return callLogs.size
    }

    override fun onBindViewHolder(holder: CallLogViewHolder, position: Int) {
        val callLog = callLogList[position]
        val itemView = holder.itemView

        itemView.findViewById<TextView>(R.id.phone_number_title_tv).text = callLog.toPhoneNumber
        itemView.findViewById<TextView>(R.id.date_text).text = callLog.date
        itemView.findViewById<TextView>(R.id.from_text).text = callLog.fromPhoneNumber
        itemView.findViewById<TextView>(R.id.call_log_file_tv).text = callLog.fileName
        val incomingText = itemView.findViewById<TextView>(R.id.incoming_text)
        if(callLog.isIncoming){
           incomingText.text = "Incoming"
        }else{
            incomingText.text = "Outgoing"
        }
    }
}