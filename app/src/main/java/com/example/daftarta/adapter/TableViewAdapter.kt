    package com.example.daftarta.adapter

    import androidx.recyclerview.widget.RecyclerView
    import android.view.LayoutInflater
    import android.view.View
    import android.view.ViewGroup
    import android.widget.TextView
    import com.example.daftarta.R
    import com.example.daftarta.obj.Mahasiswa


    class TableViewAdapter(private val userList: List<Mahasiswa>) : RecyclerView.Adapter<TableViewAdapter.RowViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowViewHolder {
            val itemView = LayoutInflater.from(parent.context).inflate(R.layout.data_daftar_user, parent, false)
            return RowViewHolder(itemView)
        }

        private fun setHeaderBg(view: View) {
            view.setBackgroundResource(R.drawable.cell_daftar)
        }

        private fun setContentBg(view: View) {
            view.setBackgroundResource(R.drawable.cell_daftar)
        }

        override fun onBindViewHolder(holder: RowViewHolder, position: Int) {
            val rowPos = holder.adapterPosition

            if (rowPos == 0) {
                // Header Cells. Main Headings appear here
                holder.apply {
                    setHeaderBg(date)
                    setHeaderBg(judul)
                    setHeaderBg(status)

                    date.text = "Tanggal"
                    judul.text = "Judul"
                    status.text = "Status"
                }
            } else {
                val modal = userList[rowPos - 1]

                holder.apply {
                    setContentBg(date)
                    setContentBg(judul)
                    setContentBg(status)

                    date.text = modal.date
                    judul.text = modal.judul
                    status.text = modal.status
                }
            }
        }

        override fun getItemCount(): Int {
            return userList.size + 1 // one more to add header row
        }

        inner class RowViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val date: TextView = itemView.findViewById(R.id.tanggal)
            val judul: TextView = itemView.findViewById(R.id.judulTA)
            val status: TextView = itemView.findViewById(R.id.status)

        }
    }