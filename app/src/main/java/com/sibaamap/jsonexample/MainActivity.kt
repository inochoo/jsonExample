package com.sibaamap.jsonexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.sibaamap.jsonexample.Model.Phone
import com.sibaamap.jsonexample.Model.UserModelClass
import com.sibaamap.jsonexample.Model.Users
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException
import java.nio.charset.Charset

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rcvUsersList = findViewById<RecyclerView>(R.id.rvUserList)
        val usersList: ArrayList<UserModelClass> = ArrayList()

        try {
            val jsonString = getJSONFromAssets()!!
            val users = Gson().fromJson(jsonString, Users::class.java)
            // As we have JSON object, so we are getting the object
            //Here we are calling a Method which is returning the JSON object
            val obj = JSONObject(getJSONFromAssets()!!)
            // fetch JSONArray named users by using getJSONArray
            val usersArray = obj.getJSONArray("users")
            // Get the users data using for loop i.e. id, name, email and so on

            for (i in 0 until usersArray.length()) {
                // Create a JSONObject for fetching single User's Data
                val user = usersArray.getJSONObject(i)
                // Fetch id store it in variable
                val id = user.getInt("id")
                val name = user.getString("name")
                val email = user.getString("email")
                val gender = user.getString("gender")
                val weight = user.getDouble("weight")
                val height = user.getInt("height")

                // create a object for getting phone numbers data from JSONObject
                val phone = user.getJSONObject("phone")
                // fetch mobile number
                val mobile = phone.getString("mobile")
                // fetch office number
                val office = phone.getString("office")

                val phone1 = Phone(mobile,office)

                //add all the variables to the data model class and the data model class to the array list.
                val userDetails =
                    UserModelClass(id, name, email, gender, weight, height, phone1)

                // add the details in the list
                usersList.add(userDetails)
            }
        } catch (e: JSONException) {
            //exception
            e.printStackTrace()
        }

        // Set the LayoutManager that this RecyclerView will use.
        rcvUsersList.layoutManager = LinearLayoutManager(this)
        // Adapter class is initialized and list is passed in the param.
        val itemAdapter = UserAdapter(this, usersList)
        // adapter instance is set to the recyclerview to inflate the items.
        rcvUsersList.adapter = itemAdapter

    }


    /**
     * Method to load the JSON from the Assets file and return the object
     */
    private fun getJSONFromAssets(): String? {

        var json: String? = null
        val charset: Charset = Charsets.UTF_8
        try {
            val myUsersJSONFile = assets.open("Users.json")
            //size of file
            val size = myUsersJSONFile.available()
            //transfer array byte
            val buffer = ByteArray(size)
            //read file
            myUsersJSONFile.read(buffer)
            //read done then close file
            myUsersJSONFile.close()
            //
            json = String(buffer, charset)
        } catch (ex: IOException) {
            ex.printStackTrace()
            return null
        }
        return json
    }



}