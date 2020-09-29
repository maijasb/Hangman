import scala.io.StdIn.{readChar, readInt, readLine}

object hman extends App {

  //for input file
  val srcName = "words.txt"
  def openSource(fName:String) = {
    val filePointer = scala.io.Source.fromFile(srcName)
    val allWords = filePointer.getLines.toSeq
    filePointer.close()
    allWords
  }
  //to get random hangname
  def getWord(words : List[String]) : String = {
    words(scala.util.Random.nextInt(words.length))
  }

  // Split the word into individual letters.
  def splitWord(word : String) : List[Char] = {
    word.toList
  }

  println("Write a word your partner will have to guess: ")
  var hangName = readLine
  println(("*\n") *10)
  //var hangName = openSource(srcName)(getWord())



  var hangList = splitWord(hangName)
  var PlayerHangList = splitWord(hangName)
  var other = splitWord("-" * PlayerHangList.size)
  var usedLetters : Set[Char] = Set()


  while (PlayerHangList.nonEmpty) {
    println(s" this is the name $other")
    var guess = readChar
    if (PlayerHangList.contains(guess)) {
      println("correct guess!")
      PlayerHangList = PlayerHangList.filter(t => t != guess)
    }
    else println("Wrong!")
    usedLetters += guess
    println(s"You have used these letters: $usedLetters")

    other = other.zip(hangList).map({case(g,h) => if (guess == h) h else g})
  }
  println(s"You won! The name indeed is $hangName")
}




//how many players are playing
//
//  println("Do you want to play alone (enter 1) or with another person (enter 2)?")
//  val players = readInt
//
//  if (players = 1) {
//    //read file, get hangname
//
//      val source = io.Source.fromFile( fname )
//      val words : List[String] = source.getLines.toList
//      source.close()
//      words
//
//
//    // Return a random word from the passed list.
//    def randomWord(words : List[String]) : String = {
//      words( scala.util.Random.nextInt(words.length) )
//    }
//  }
//  else
//    //hangname = readLine
