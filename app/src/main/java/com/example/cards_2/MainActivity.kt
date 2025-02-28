package com.example.cards_2

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.ArrayList
import java.util.Calendar

class MainActivity : AppCompatActivity() {
    var main_list = mutableListOf<List<Int>>()
    var main_list2 = mutableListOf<List<Int>>()
    val calendar = Calendar.getInstance()
    var day = calendar.get(Calendar.DAY_OF_WEEK)
    var day_num = calendar.get(Calendar.WEEK_OF_MONTH)
    var hour = calendar.get(Calendar.HOUR_OF_DAY)
    var minuet = calendar.get(Calendar.MINUTE)
    val month = calendar.get(Calendar.MONTH)
    var date = calendar.get(Calendar.DATE)
    var card_month = Database.cards[month]
    var card_hour = Database.cards[hour%12]
    var card_minuet = Database.cards[minuet/5]
    var weapon2 = mutableListOf("ю корону", "ё кольцо", "й меч", "й колокольчик")
    var list2 = mutableListOf("ума", "чувства", "силы", "фантазии")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val list0 = ArrayList<Int>()
        val list1 = ArrayList<Int>()
        val list2 = ArrayList<Int>()
        val list3 = ArrayList<Int>()
        val list4 = ArrayList<Int>()
        val list5 = ArrayList<Int>()

        for (i in 0..5) {
            for (j in 0..11) {
                // Получаем ID картинки
                val resId = resources.getIdentifier(
                    "drawable/k${i}_$j",
                    "drawable",
                    application.packageName
                )

                // Добавляем ID в соответствующий список
                when (i) {
                    0 -> list0.add(resId)
                    1 -> list1.add(resId)
                    2 -> list2.add(resId)
                    3 -> list3.add(resId)
                    4 -> list4.add(resId)
                    5 -> list5.add(resId)
                }
            }
        }
        main_list.add(list0.toMutableList())
        main_list.add(list1.toMutableList())
        main_list.add(list2.toMutableList())
        main_list.add(list3.toMutableList())
        main_list.add(list4.toMutableList())
        main_list.add(list5.toMutableList())

        val list6 = ArrayList<Int>()
        val list7 = ArrayList<Int>()
        val list8 = ArrayList<Int>()
        val list9 = ArrayList<Int>()
        val list10 = ArrayList<Int>()
        val list11 = ArrayList<Int>()

        for (i in 0..5) {
            for (j in 0..11) {
                // Получаем ID картинки
                val resId = resources.getIdentifier(
                    "drawable/k${i}_$j" + 'r',
                    "drawable",
                    application.packageName
                )

                // Добавляем ID в соответствующий список
                when (i) {
                    0 -> list6.add(resId)
                    1 -> list7.add(resId)
                    2 -> list8.add(resId)
                    3 -> list9.add(resId)
                    4 -> list10.add(resId)
                    5 -> list11.add(resId)
                }
            }
        }

        main_list2.add(list6.toMutableList())
        main_list2.add(list7.toMutableList())
        main_list2.add(list8.toMutableList())
        main_list2.add(list9.toMutableList())
        main_list2.add(list10.toMutableList())
        main_list2.add(list11.toMutableList())
        cards()
        first()
        second()
        third()
        fourth()
        rocks()
    }

    fun cards(){
        var card1 = findViewById<ImageView>(R.id.card1)
        var card2 = findViewById<ImageView>(R.id.card2)
        var card3 = findViewById<ImageView>(R.id.card3)
        card2.setImageResource(main_list[day-1][hour%12])
        main_list.removeAt(day-1)
        card1.setImageResource(main_list[day_num-1][month])
        if (minuet%5 == 0){
            var img3 = main_list[(day+5)%6][minuet/5]
            card3.setImageResource(img3)
        }
        else{
            var img3 = main_list[(day+minuet%5)%6][minuet/5]
            card3.setImageResource(img3)
        }
//        card3.setImageResource(main_list[minuet%5][minuet/5])

    }
    fun first(){
        var date_text = findViewById<TextView>(R.id.date_text)
        var letter_text = findViewById<TextView>(R.id.letters_text)
        val months = mutableListOf(" января,", " февраля,", " мая,", " апреля,", " мая,", " июня,", " июля,", " августа,", " сентября,", " октября,", " ноября,", " декабря,")
        val days_of_week = mutableListOf(" воскресенье, "," понедельник, ", " вторник, "," среда, "," четверг, "," пятница, "," суббота, ")
        date_text.text = date.toString() + months[month] + " "+hour.toString()+ ":" + minuet.toString()
        letter_text.text = Database.consonant[month]+Database.vowel[day_num-1][day-1] + " " + Database.consonant[hour%12]+Database.hour_vowel[day-1] + " " + Database.consonant[minuet/5]+Database.vowel[minuet%5][day-1]

    }
    fun second(){
        var date_text = findViewById<TextView>(R.id.date_text2)
        var nums = mutableListOf("перв", "втор", "трет", "четверт", "пят")
        val days_of_week = mutableListOf("ое воскресенье","ый понедельник", "ой вторник","ая среда","ый четверг","ая пятница","ая суббота")
        val months = mutableListOf(" января", " февраля", " мая", " апреля", " мая", " июня", " июля", " августа", " сентября", " октября", " ноября", " декабря")
        date_text.text = nums[day_num-1]+days_of_week[day-1]+months[month]

        var text1 = findViewById<TextView>(R.id.text1)
        var text2 = findViewById<TextView>(R.id.text2)

        if (hour<12){
            var heroes = Database.heroes_with_end1
            heroes[month].removeAt(day-1)
            text1.text = "Молод" + heroes[month][day_num-1] + " "+Database.verb[day_num-1][0] + Database.verb[day_num-1][1]+"."
        }
        else{
            var heroes = Database.heroes_with_end2
            heroes[month].removeAt(day-1)
            text1.text = "Стар" + heroes[month][day_num-1] + " " +Database.verb[day_num-1][0] + Database.verb[day_num-1][1]+"."
        }
        text2.text = Database.second_text[day_num-1][day-1]

    }
    fun third(){
        val date_text = findViewById<TextView>(R.id.date_text3)
        val hours = mutableListOf("двенадцатого ","первого ", "второго ", "третьего ", "четвертого ", "пятого ", "шестого ", "седьмого ", "восьмого ", "девятого ", "десятого ", "одиннадцатого ")
        date_text.text = minuet.toString()+"-Я МИНУТА "+ hours[hour%12]+"ЧАСА"
        var text3 = findViewById<TextView>(R.id.text3)
        var text4 = findViewById<TextView>(R.id.text4)
        var heroes3 = Database.heroes3
        var heroes2 = Database.heroes2
        heroes2[minuet/5].removeAt(day-1)
        heroes3[minuet/5].removeAt(day-1)
        var heroes21 = heroes2[minuet/5]
        var heroes31 = heroes3[minuet/5]
        var verb = Database.verb3[minuet%5][day-1]
        if (verb == "созерцает" || verb == "учит"){
            text3.text = Database.heroes[hour%12][day-1] + " " + verb + " " + heroes31[minuet%5] + " " + Database.emotions[minuet%5]
        }
        else{
            text3.text = Database.heroes[hour%12][day-1] + " " + verb + " " + heroes21[minuet%5] + " " + Database.emotions[minuet%5]
        }
        val role = Database.role
        if (hour<12){ //hour minus
            if(card_month[6] == card_hour[6] &&  card_hour[6] == card_minuet[6]){
                text4.text = "Абсолютн " + Database.properties[month] + " " + role[month] + "  побеждает"

            }
            else if(card_month[6] == card_minuet[6]){
                text4.text = "Удвоенное " + Database.properties[minuet/5] + " помогает " +  Database.properties[minuet/5]
            }
            else if(card_month[6] == card_hour[6]){
                text4.text = "Удвоенное " + Database.properties[minuet/5] + " мешает " +  Database.properties[hour%12]
            }
            else if(card_hour[6] == card_minuet[6]){
                text4.text = "Удвоенное " + Database.properties[minuet/5] + " неясно как влияет на " +  Database.properties[hour%12]
            }
            else{
                text4.text =  role[minuet/5] + " помогает или мешает " + Database.role2[hour%12] + " стать " + Database.role3[month]
            }
        }
        else { //minute minus
            if (card_month[6] == card_hour[6] && card_hour[6]== card_minuet[6]) {
                text4.text =
                    "Абсолютн " + Database.properties[month] + " " + role[month] + "  побеждает"

            } else if (card_month[6] == card_minuet[6]) {
                text4.text =
                    "Удвоенное " + Database.properties[minuet / 5] + " мешает " + Database.properties[hour % 12]

            } else if (card_month[6] == card_hour[6]) {
                text4.text =
                    "Удвоенное " + Database.properties[minuet / 5] + " помогает " + Database.properties[minuet / 5]
            } else if (card_hour[6] == card_minuet[6]) {
                text4.text =
                    "Удвоенное " + Database.properties[minuet / 5] + " неясно как влияет на " + Database.properties[hour % 12]
            } else {
                text4.text =
                    role[minuet / 5] + " помогает или мешает " + Database.role2[hour%12] + " стать " + Database.role3[month]
            }
        }
    }
    fun fourth(){
        var date_text = findViewById<TextView>(R.id.date_text4)
        date_text.text = Database.role[month] + " " + Database.role[hour%12] + " " + Database.role[minuet/5]
        val text5 = findViewById<TextView>(R.id.text5)
        val text6 = findViewById<TextView>(R.id.text6)
        if (hour<12){ //hour minus
            if(card_month[0] == card_hour[0] && card_hour[0] == card_minuet[0]){
                text5.text = "Снаружи "+ card_month[4] + " все " + Database.attr_pad[card_month[0] as Int][1]
            }
            else if(card_month[0] == card_minuet[0]){
                text5.text = "Снаружи двойн" + Database.prop_pad[card_month[0] as Int][1] + " помогает " + Database.prop_pad[card_hour[0] as Int][2]
            }
            else if(card_month[0] == card_hour[0]){
                text5.text = "Снаружи двойн" + Database.prop_pad[card_month[0] as Int][1] + " мешает " + Database.prop_pad[card_minuet[0] as Int][2]
            }
            else if(card_hour[0] == card_minuet[0]){
                text5.text = "Снаружи двойн" + Database.prop_pad[card_hour[0] as Int][1] + " неяснно как повлияет на " + Database.prop_pad[card_month[0] as Int][0]
            }
            else{
                var weapon2 = mutableListOf("ю корону", "ё кольцо", "й меч", "й колокольчик")
                var list2 = mutableListOf("ума", "чувства", "силы", "фантазии")
                list2.remove(Database.prop_pad[card_month[0] as Int][0])
                list2.remove(Database.prop_pad[card_hour[0]as Int] [0])
                list2.remove(Database.prop_pad[card_minuet[0] as Int][0])
                weapon2.remove(Database.attr_pad[card_month[0] as Int][0])
                weapon2.remove(Database.attr_pad[card_hour[0] as Int] [0])
                weapon2.remove(Database.attr_pad[card_minuet[0] as Int][0])
                text5.text = "Снаружи нет "+ list2[0]+ " ищи сво" + weapon2[0]
            }

            if(card_month[1] == card_hour[1] && card_hour[1] == card_minuet[1]){
                text6.text = "Внутри "+ card_month[4] + " все " +Database.attr_pad[card_month[1] as Int][1]
            }
            else if(card_month[1] == card_minuet[1]){
                text6.text = "Внутри дв"+ Database.attr_pad[card_month[1] as Int][2] + " " + card_hour[6] + " " + Database.prop_pad[card_hour[1] as Int][2]
            }
            else if(card_month[1] == card_hour[1]){
                text6.text = "Внутри дв"+ Database.attr_pad[card_month[1] as Int][2] + " " + card_hour[7] + " " +Database.prop_pad[card_minuet[1] as Int][2]

            }
            else if(card_hour[1] == card_minuet[1]){
                text6.text = "Внутри дв"+ Database.attr_pad[card_hour[1] as Int][2] +card_hour[6] + "или" + card_hour[7]+  " " + Database.attr_pad[card_month[1] as Int][3] + " "+Database.prop_pad[card_month[1] as Int][0]
            }
            else{
                var weapon2 = mutableListOf("ю корону", "ё кольцо", "й меч", "й колокольчик")
                var list2 = mutableListOf("ума", "чувства", "силы", "фантазии")
                list2.remove(Database.prop_pad[card_month[1] as Int][0])
                list2.remove(Database.prop_pad[card_hour[1]as Int] [0])
                list2.remove(Database.prop_pad[card_minuet[1] as Int][0])
                weapon2.remove(Database.attr_pad[card_month[1] as Int][0])
                weapon2.remove(Database.attr_pad[card_hour[1] as Int] [0])
                weapon2.remove(Database.attr_pad[card_minuet[1] as Int][0])
                text6.text = "Внутри нет "+ list2[0]+ " ищи сво" + weapon2[0]
            }
        }
        else{ //minute minus
            if(card_month[0] == card_hour[0] && card_hour[0] == card_minuet[0]){
                text5.text = "Снаружи "+ card_month[4] + " все " + Database.attr_pad[card_month[0] as Int][1]
            }
            else if(card_month[0] == card_minuet[0]){
                text5.text = "Снаружи двойн" + Database.prop_pad[card_month[0] as Int][1] + " мешает " + Database.prop_pad[card_hour[0] as Int][2]
            }
            else if(card_month[0] == card_hour[0]){
                text5.text = "Снаружи двойн" + Database.prop_pad[card_month[0] as Int][1] + " помогает " + Database.prop_pad[card_minuet[0] as Int][2]
            }
            else if(card_hour[0] == card_minuet[0]){
                text5.text = "Снаружи двойн" + Database.prop_pad[card_hour[0] as Int][1] + " неясно как повлияет на " + Database.prop_pad[card_month[0] as Int][3]
            }
            else{
                var weapon2 = mutableListOf("ю корону", "ё кольцо", "й меч", "й колокольчик")
                var list2 = mutableListOf("ума", "чувства", "силы", "фантазии")
                list2.remove(Database.prop_pad[card_month[0] as Int][0])
                list2.remove(Database.prop_pad[card_hour[0]as Int] [0])
                list2.remove(Database.prop_pad[card_minuet[0] as Int][0])
                weapon2.remove(Database.attr_pad[card_month[0] as Int][0])
                weapon2.remove(Database.attr_pad[card_hour[0] as Int] [0])
                weapon2.remove(Database.attr_pad[card_minuet[0] as Int][0])
                text5.text = "Снаружи нет "+ list2[0]+ " ищи сво" + weapon2[0]
            }

            if(card_month[1] == card_hour[1] && card_hour[1] == card_minuet[1]){
                text6.text = "Внутри "+ card_month[4] + " все " +Database.attr_pad[card_month[1] as Int][1]
            }
            else if(card_month[1] == card_minuet[1]){

                text6.text = "Внутри дв"+ Database.attr_pad[card_month[1] as Int][2] + " " + card_hour[7] + " " +Database.prop_pad[card_minuet[1] as Int][2]
            }
            else if(card_month[1] == card_hour[1]){
                text6.text = "Внутри дв"+ Database.attr_pad[card_month[1] as Int][2] + " " + card_hour[6] + " " + Database.prop_pad[card_hour[1] as Int][2]
            }
            else if(card_hour[1] == card_minuet[1]){
                text6.text = "Внутри дв"+ Database.attr_pad[card_hour[1] as Int][2] +" "+ card_hour[6] + " или " + card_hour[7] + " " + Database.attr_pad[card_month[1] as Int][3] + " "+Database.prop_pad[card_month[1] as Int][0]
            }
            else{
                var weapon2 = mutableListOf("ю корону", "ё кольцо", "й меч", "й колокольчик")
                var list2 = mutableListOf("ума", "чувства", "силы", "фантазии")
                list2.remove(Database.prop_pad[card_month[1] as Int][0])
                list2.remove(Database.prop_pad[card_hour[1]as Int] [0])
                list2.remove(Database.prop_pad[card_minuet[1] as Int][0])
                weapon2.remove(Database.attr_pad[card_month[1] as Int][0])
                weapon2.remove(Database.attr_pad[card_hour[1] as Int] [0])
                weapon2.remove(Database.attr_pad[card_minuet[1] as Int][0])
                text6.text = "Внутри нет "+ list2[0]+ " ищи сво" + weapon2[0]
        }}

    }
    fun rocks(){
        var rock1 = findViewById<ImageView>(R.id.rock1)
        var rock2 = findViewById<ImageView>(R.id.rock2)
        var rock3 = findViewById<ImageView>(R.id.rock3)
        var figures_month = Database.figures_dark
        var figures = Database.figures
        if (hour>12){
            figures_month = Database.figures
        }
        rock2.setImageResource(figures[day-1][hour%12])
        rock1.setImageResource(figures_month[day_num-1][month])
//        rock3.setImageResource(figures[minuet%5][minuet/5])
        if (minuet%5 == 0){
            var img3 = figures[(day+5)%6][minuet/5]
            rock3.setImageResource(img3)
        }
        else{
            var img3 = figures[(day+minuet%5)%6][minuet/5]
            rock3.setImageResource(img3)
        }

    }
}