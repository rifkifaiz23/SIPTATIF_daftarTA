
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.daftarta.R
import com.example.daftarta.obj.MHS_Status

class AdapterMHSStatus(private val userList: ArrayList<MHS_Status>, private val itemClickListener: OnItemClickListener) : RecyclerView.Adapter<AdapterMHSStatus.RowViewHolder>() {

    private val HEADER_POSITION = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.table_status_daftar, parent, false)
        return RowViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: RowViewHolder, position: Int) {
        val rowPos = holder.adapterPosition

        if (rowPos == 0) {
            // Header Cells. Main Headings appear here
            holder.apply {
                setHeaderBg(date)
                setHeaderBg(judul)
                setHeaderBg(status)
                setContentBg(aksi)

                date.text = "Tanggal"
                judul.text = "Judul"
                status.text = "Status"
                aksi.text = "Aksi"
            }
        } else {
            val modal = userList[rowPos - 1]

            holder.apply {
                setContentBg(date)
                setContentBg(judul)
                setContentBg(status)
                setContentBg(aksi)

                date.text = modal.date
                judul.text = modal.judul
                status.text = modal.status
                aksi.text = modal.aksi

                aksi.isEnabled = true
                // Tambahkan listener untuk menangani klik pada konten
                aksi.setOnClickListener {
                    itemClickListener.onItemClick(rowPos - 1) // Kurangi satu untuk mengabaikan header
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return userList.size + 1 // one more to add header row
    }

    override fun getItemViewType(position: Int): Int {
        // Tentukan tipe view untuk setiap posisi
        return if (position == HEADER_POSITION) 0 else 1
    }

    inner class RowViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        val date: TextView = itemView.findViewById(R.id.tanggal)
        val judul: TextView = itemView.findViewById(R.id.judulTA)
        val status: TextView = itemView.findViewById(R.id.status)
        val aksi: TextView = itemView.findViewById(R.id.aksi)

        init {
            aksi.setOnClickListener(this)
        }

        override fun onClick(v: View) {
            if (adapterPosition != RecyclerView.NO_POSITION) {
                itemClickListener.onItemClick(adapterPosition - 1) // Kurangi satu untuk mengabaikan header
            }
        }
    }

    private fun setHeaderBg(view: View) {
        view.setBackgroundResource(R.drawable.cell_daftar)
    }

    private fun setContentBg(view: View) {
        view.setBackgroundResource(R.drawable.cell_daftar)
    }

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }
}
