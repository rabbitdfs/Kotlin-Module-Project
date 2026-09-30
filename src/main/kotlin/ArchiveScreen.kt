class ArchiveScreen(val menu: Menu) {
    val archives = mutableListOf<Archive>()

    fun show() {
        while (true) {
            val items = mutableListOf<MenuItem>()
            items.add(MenuItem("Создать архив") { createArchive() })
            for (archive in archives) {
                items.add(MenuItem(archive.name) { NotesScreen(menu, archive).show() })
            }
            val result = menu.showMenu("Список архивов:", items)

            if (!result) {
                break
            }
        }
    }

    fun createArchive() {
        val name = menu.readText("Введите название архива:")
        archives.add(Archive(name))
        println("Архив $name создан")
    }
}