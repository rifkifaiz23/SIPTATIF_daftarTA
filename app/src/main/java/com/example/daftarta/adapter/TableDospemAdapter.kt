package com.example.daftarta.adapter

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.daftarta.R
import com.example.daftarta.obj.Dospem


class TableDospemAdapterr(private val userList: MutableList<Dospem>
) : RecyclerView.Adapter<TableDospemAdapterr.RowViewHolder>() {

    private var filteredList: List<Dospem> = userList

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.data_dospem, parent, false)
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
                setHeaderBg(no)
                setHeaderBg(nama)
                setHeaderBg(nidn)
                setHeaderBg(jeniskelamin)
                setHeaderBg(keahlian)
                setHeaderBg(kuota)
                setHeaderBg(aksi)

                no.text = "No"
                nama.text = "Nama Dosen"
                nidn.text = "NIDN"
                jeniskelamin.text = "Jenis Kelamin"
                keahlian.text = "Keahlian"
                kuota.text = "Kuota"
                aksi.text = "Aksi"
            }
        } else {
            val modal = userList[rowPos - 1]

            holder.apply {
                setContentBg(no)
                setContentBg(nama)
                setContentBg(nidn)
                setContentBg(jeniskelamin)
                setContentBg(keahlian)
                setContentBg(kuota)
                setContentBg(aksi)

                no.text = modal.no
                nama.text = modal.nama
                nidn.text = modal.nidn
                jeniskelamin.text = modal.gender
                keahlian.text = modal.skill
                kuota.text = modal.kuota
                aksi.text = modal.aksi
            }
        }
    }

    override fun getItemCount(): Int {
        return userList.size + 1 // one more to add header row
    }

    inner class RowViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val no: TextView = itemView.findViewById(R.id.no)
        val nama: TextView = itemView.findViewById(R.id.nama)
        val nidn: TextView = itemView.findViewById(R.id.nidn)
        val jeniskelamin: TextView = itemView.findViewById(R.id.gender)
        val keahlian: TextView = itemView.findViewById(R.id.skill)
        val kuota: TextView = itemView.findViewById(R.id.kuota)
        val aksi: TextView = itemView.findViewById(R.id.aksi)

    }

    fun filter(text: String) {
        filteredList = if (text.isEmpty()) {
            userList
        } else {
            userList.filter { it.nama?.contains(text, ignoreCase = true) == true }
        }
        notifyDataSetChanged()
    }

}