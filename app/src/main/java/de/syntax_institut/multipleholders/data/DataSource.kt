package de.syntax_institut.multipleholders.data

import de.syntax_institut.multipleholders.data.model.Message

class DataSource {
    fun loadMessages() : List<Message> {
        return listOf(
            Message(true,"was läuft digga","9:08"),
            Message(false, "Bitte kaufe Mehl und Zucker","9:08"),
            Message(true,"Nicht vergessen mit dem Hund rauszugehen","9:08"),
            Message(false, "nicht vergessen zu vergessen","9:08"),
            Message(true, "Schon wieder RecyclerViews?","9:09"),
            Message(false, "Hallo Mama ich halb mein Handy verloren du musst für mich eine Rechnung zahlen", "9:09")
        )
    }
}