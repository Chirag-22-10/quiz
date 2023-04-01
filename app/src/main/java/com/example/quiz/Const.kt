package com.example.quiz

object Const {

    const val USER_NAME : String = "user_name"
    const val TOTAL_QUESTION : String = "total_question"
    const val CORRECT_ANSWER : String = "correct_answer"
    fun getQuestions() : ArrayList<Questc>{
        val questionList = ArrayList<Questc>()

        val que1 = Questc(
            1,"Who created C++", "James Gosling","Andy Rubin", "Nick Sears","Bjarne Stroustrup",4

        )
        questionList.add(que1)

        val que2 = Questc(
            1,"Who created Java", "James Gosling","Andy Rubin", "Nick Sears","Bjarne Stroustrup",1
        )
        questionList.add(que2)
        val que3 = Questc(
            1,"Who created Android", "James Gosling","Andy Rubin", "Rasmus Lerdorf","Bjarne Stroustrup",2
        )
        questionList.add(que3)

        val que4 = Questc(
            1,"Who created php", "James Gosling","Rasmus Lerdorf", "Andy Rubin","Bjarne Stroustrup",2
        )
        questionList.add(que4)

        val que5 = Questc(
            1,"Who created html", "James Gosling","Andy Rubin", "Rasmus Lerdorf","Tim Berners-Lee",4
        )
        questionList.add(que5)

        val que6 = Questc(
            1,"who created ruby", "Yukihiro Matsumoto","Andy Rubin", "Rasmus Lerdorf","Bjarne Stroustrup",1
        )
        questionList.add(que6)

        val que7 = Questc(
            1,"who created c", "James Gosling","Dennis Ritchie", "Rasmus Lerdorf","Bjarne Stroustrup",3
        )
        questionList.add(que7)

        val que8 = Questc(
            1,"who created c++", "James Gosling","Andy Rubin", "Rasmus Lerdorf","Bjarne Stroustrup",4
        )
        questionList.add(que8)

        val que9 = Questc(
            1,"who created css", "James Gosling","Andy Rubin", "HÃ¥kon Wium Lie","Bjarne Stroustrup",3
        )
        questionList.add(que9)

        val que10 = Questc(
            1,"who created python", "Guido van Rossum","Andy Rubin", "Rasmus Lerdorf","Bjarne Stroustrup",1
        )
        questionList.add(que10)
        return questionList
    }
}