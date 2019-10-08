package com.kevinjanvier.freshchat

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.freshchat.consumer.sdk.Freshchat
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Get the user object for the current installation
        val freshUser = Freshchat.getInstance(applicationContext).user

        freshUser.firstName = "Kevin"
        freshUser.lastName = "Janvier"
        freshUser.email = "domain277@mail.com"
        freshUser.setPhone("+256", "785077853")

//Call setUser so that the user information is synced with Freshchat's servers
        Freshchat.getInstance(applicationContext).user = freshUser

        btnShowFAQs.setOnClickListener(viewClickListener)
        btnShowConversations.setOnClickListener(viewClickListener)


        /* Set any custom metadata to give agents more context, and
        for segmentation for marketing or pro-active messaging */
        val userMeta = HashMap<String, String>()
        userMeta["userLoginType"] = "Facebook"
        userMeta["city"] = "SpringField"
        userMeta["age"] = "22"
        userMeta["userType"] = "premium"
        userMeta["numTransactions"] = "5"
        userMeta["usedWishlistFeature"] = "yes"

//Call setUserProperties to sync the user properties with Freshchat's servers
        Freshchat.getInstance(applicationContext).setUserProperties(userMeta)
    }

    val viewClickListener = View.OnClickListener { v ->
        if (v.id === R.id.btnShowFAQs) {

            Freshchat.showFAQs(this@MainActivity)

        } else if (v.id === R.id.btnShowConversations) {

            Freshchat.showConversations(this@MainActivity)

        }
    }
}
