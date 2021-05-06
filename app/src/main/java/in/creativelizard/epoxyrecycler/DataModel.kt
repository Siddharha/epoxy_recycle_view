package `in`.creativelizard.epoxyrecycler
import com.google.gson.annotations.SerializedName


data class DataModel(
    @SerializedName("items")
    val items: List<Item>
) {
    data class Item(
        @SerializedName("age")
        val age: Int,
        @SerializedName("name")
        val name: String,
        @SerializedName("number")
        val number: Long
    )
}

fun getData()= run {
    DataModel(listOf(
        DataModel.Item(35, "Siddhartha Maji", 9564751914),
        DataModel.Item(35, "Siddhartha Maji", 9564751914),
        DataModel.Item(35, "Siddhartha Maji", 9564751914),

        ))
}