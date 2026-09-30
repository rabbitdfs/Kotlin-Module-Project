class NotesScreen(val menu: Menu, val archive: Archive) {
    fun show() {
        while (true) {
            val items = mutableListOf<MenuItem>()
            items.add(MenuItem("Создать заметку") { createNote() })
            for (note in archive.notes) {
                items.add(MenuItem(note.name) { NoteScreen(menu, note).show() })
            }
            if (!menu.showMenu("Архив ${archive.name}:", items)) {
                break
            }
        }
    }

    fun createNote() {
        val name = menu.readText("Введите название заметки:")
        val text = menu.readText("Введите текст заметки:")
        archive.notes.add(Note(name, text))
        println("Заметка $name создана")
    }
}