class NoteScreen(val menu: Menu, val note: Note) {
    fun show() {
        val items = listOf(
            MenuItem("Показать текст") { println(note.text) }
        )

        while (true) {
            val result = menu.showMenu("Заметка ${note.name}:", items)

            if (!result) {
                break
            }
        }
    }
}