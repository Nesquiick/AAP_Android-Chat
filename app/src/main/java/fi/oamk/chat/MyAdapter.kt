package fi.oamk.chat

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter (private val myDataset: ArrayList<Message>): RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent : ViewGroup, viewType: Int): MyViewHolder {
        val myView = LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_item,parent,false)
        return MyViewHolder(myView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.message.text = myDataset.get(position).message
        holder.author.text = "by "+ myDataset.get(position).author + " on"+myDataset.get(position).time
    }

    override fun getItemCount() = myDataset.size

    class MyViewHolder (itemView: View): RecyclerView.ViewHolder(itemView){
        val message: TextView = itemView.findViewById(R.id.message)
        val author: TextView = itemView.findViewById(R.id.author)
    }
}