package com.example.quiz

object Const {

    fun getQuestions() : ArrayList<Questc>{
        val questionList = ArrayList<Questc>()

        val que1 = Questc(
            1,"Who created C++", "James Gosling","Andy Rubin", "Nick Sears","Bjarne Stroustrup",4

        )
        questionList.add(que1)

        val que2 = Questc(
            1,"Who created Java", "James Gosling","Andy Rubin", "Nick Sears","Bjarne Stroustrup",4
        )
        questionList.add(que2)
        val que3 = Questc(
            1,"Who created Android", "James Gosling","Andy Rubin", "Nick Sears","Bjarne Stroustrup",4
        )
        questionList.add(que3)
        return questionList
    }
}