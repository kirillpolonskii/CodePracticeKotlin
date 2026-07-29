package top_interview_150.array_string.hard

class Solution68 {
    fun fullJustify(words: Array<String>, maxWidth: Int): List<String> {
        val wordMatr = mutableListOf(mutableListOf<String>())
        val spaceMatr = mutableListOf(mutableListOf<Int>())
        var curStrLength = 0
        var curStrRow = 0
        var i = 0
        while (i < words.size) {
            wordMatr.forEach {
                it.forEach { str -> print("$str ") }
                println() }
            spaceMatr.forEach {
                it.forEach { spacesCount -> print("$spacesCount ") }
                println() }
            println("curWord is ${words[i]}")
            // add word and check if it's out of maxWidth
            wordMatr[curStrRow].add(words[i])
            spaceMatr[curStrRow].add(1)
            curStrLength += words[i].length + 1
            println("curStrLength is ${curStrLength}")
            // delete space, then, if still > maxWidth, cur word
            if (curStrLength > maxWidth) {
                --spaceMatr[curStrRow][spaceMatr[curStrRow].size - 1]
                --curStrLength
                if (curStrLength > maxWidth) {
                    spaceMatr[curStrRow].removeLast()
                    wordMatr[curStrRow].removeLast()
                    --spaceMatr[curStrRow][spaceMatr[curStrRow].size - 1]
                    --curStrLength
                    curStrLength -= words[i].length
                    println("$curStrLength before filling with spaces")
                    while (curStrLength != maxWidth){
                        for (j in spaceMatr[curStrRow].indices) {
                            if (curStrLength == maxWidth){
                                break
                            }
                            else {
                                if (spaceMatr[curStrRow][j] != 0 || wordMatr[curStrRow].size == 1) {
                                    ++spaceMatr[curStrRow][j]
                                    ++curStrLength
                                }
                            }
                        }
                    }
                    ++curStrRow
                    curStrLength = 0
                    wordMatr.add(mutableListOf())
                    spaceMatr.add(mutableListOf())
                    //++i
                }
                else if (curStrLength == maxWidth){
                    if (i < words.size - 1) {
                        ++curStrRow
                        curStrLength = 0
                        wordMatr.add(mutableListOf())
                        spaceMatr.add(mutableListOf())

                    }
                    ++i
                }
                else {
                    println("HOW TF ARE YOU HERE")
                    ++i

                }
            }
            else if (curStrLength == maxWidth) {
                if (wordMatr[curStrRow].size != 1 && i != words.size - 1){
                    --spaceMatr[curStrRow][spaceMatr[curStrRow].size - 1]
                    --curStrLength
                }
                println("$curStrLength before filling with spaces")
                while (curStrLength != maxWidth){
                    for (j in spaceMatr[curStrRow].indices) {
                        if (curStrLength == maxWidth){
                            break
                        }
                        else {
                            if (spaceMatr[curStrRow][j] != 0 || wordMatr[curStrRow].size == 1) {
                                ++spaceMatr[curStrRow][j]
                                ++curStrLength
                            }
                        }
                    }
                }
                if (i < words.size - 1) {
                    ++curStrRow
                    curStrLength = 0
                    wordMatr.add(mutableListOf())
                    spaceMatr.add(mutableListOf())

                }
                ++i
            }
            else {
                ++i
            }
        }

        // fill the rest with spaces from left to right on the last line
        println("$curStrLength before filling with spaces on the last line")
        while (curStrLength != maxWidth){
            ++spaceMatr[curStrRow][spaceMatr[curStrRow].size - 1]
            ++curStrLength
        }
        wordMatr.forEach {
            it.forEach { str -> print("$str ") }
            println() }
        spaceMatr.forEach {
            it.forEach { spacesCount -> print("$spacesCount ") }
            println() }
        // form a list of strings from matrices
        val resList = mutableListOf<String>()
        for (strRow in 0..<wordMatr.size){
            var curWordInd = 0
            var curString = StringBuilder()
            while (curWordInd < wordMatr[strRow].size){
                curString.append(wordMatr[strRow][curWordInd])
                repeat(spaceMatr[strRow][curWordInd]){ // append all corresponding spaces
                    curString.append(" ")
                }

                ++curWordInd
            }
            resList.add(curString.toString())
        }
        resList.forEach {
            println(it)
        }
        return resList
    }
}

fun main() {
    /*println(Solution68().fullJustify(
        arrayOf("This", "is", "an", "example", "of", "text", "justification."),
        16))*/
    /*println(Solution68().fullJustify(
        arrayOf("This", "is", "an", "example", "of", "text", "justification.", "etcetera"),
        16))*/
    /*println(Solution68().fullJustify(
        arrayOf("What","must","be","acknowledgment","shall","be"),
        16))*/
    /*println(Solution68().fullJustify(
        arrayOf("ask","not","what","your","country","can","do","for","you","ask","what","you","can","do","for","your","country"),
        16))*/
    println(Solution68().fullJustify(
        arrayOf("a","b","c","d","e","f"),
        6))
    /*println(Solution68().fullJustify(
        arrayOf("My","momma","always","said,","\"Life","was","like","a","box","of","chocolates.","You","never","know","what","you're","gonna","get."),
        20))*/

}