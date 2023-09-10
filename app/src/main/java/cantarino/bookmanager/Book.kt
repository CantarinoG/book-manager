package cantarino.bookmanager

class Book(var id: Int, var name: String, var author: String, var pages: Int, var imageURL: String, var shortDesc: String, var longDesc: String, var isExpanded: Boolean = false)