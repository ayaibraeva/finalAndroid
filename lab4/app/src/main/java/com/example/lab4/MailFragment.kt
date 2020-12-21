package com.example.lab4
import android.os.Bundle
import android.os.Message
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.mail_detail_fragment.*
import kotlinx.android.synthetic.main.mail_fragment.*
class MailFragment(): Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.mail_fragment, container, false)
    }

    private var messageAdapter: com.example.lab4.Adapter? = null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val messages: MutableList<com.example.lab4.Message> = mutableListOf()
        messages.add(com.example.lab4.Message("Title 1", "Ayaulym", "textTexttextText"))
        messages.add(com.example.lab4.Message("Title 2", "Zarina", "fdfs"))
        messages.add(com.example.lab4.Message("Title 3", "Dayana", "fsdfs"))
        messages.add(com.example.lab4.Message("Title 4", "Diana", "vcxv"))
        messages.add(com.example.lab4.Message("Title 5", "Sender1", "hythht"))
        messages.add(com.example.lab4.Message("Title 6", "Sender2", "wedw"))
        messages.add(com.example.lab4.Message("Title 7", "Sender3", "mama"))
        messages.add(com.example.lab4.Message("Title 8", "Sender4", "dd[w"))
        messages.add(com.example.lab4.Message("Title 9", "Sender5", "textTex[f[[ttextText"))
        messages.add(com.example.lab4.Message("Title 10", "Sender5", "ewqe"))
        messageAdapter = Adapter(messageClickListener = { this.openMail(it)
        }

        )
        val manager= LinearLayoutManager(context)
        messageRecyclerView.apply { layoutManager= manager
            adapter = messageAdapter
        }
        messageAdapter?.addItems(messages)


    }

    private fun openMail(text: String) {
        fragmentManager
            ?.beginTransaction()
            ?.replace(R.id.right, MailDetail.create(text))
            ?.apply {addToBackStack(this::class.java.simpleName)
                ?.commit()
            }
    }
}