package `in`.creativelizard.epoxyrecycler
import com.airbnb.epoxy.AutoModel
import com.google.gson.annotations.SerializedName


data class DataModel(
    @SerializedName("dataList")
    val dataList: List<Data>
) {
    data class Data(
            @SerializedName("contentType")
            val contentType: String,
            @SerializedName("data")
            val contentData: Any
    )
}

data class HeaderData(
    @SerializedName("items")
    val items: List<Item>
) {
    data class Item(
            @SerializedName("id")
            val id: Int,
            @SerializedName("image")
            val image: String,
            @SerializedName("name")
            val name: String
    )
}

data class BodyData(
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
    data class FooterData(
    @SerializedName("subtitle")
    val subtitle: String,
    @SerializedName("title")
    val title: String
)

fun getData(): DataModel {
    val header = HeaderData(listOf(
            HeaderData.Item(0,"","Item 1"),
            HeaderData.Item(1,"","Item 2"),
            HeaderData.Item(2,"","Item 3")
    ))

    val body = BodyData(listOf(
            BodyData.Item(35,"Siddhartha Maji",9564751914),
            BodyData.Item(35,"Siddhartha Maji",9564751914),
            BodyData.Item(35,"Siddhartha Maji",9564751914)
    ))
    
    val footer = FooterData("test Footer","Test Footer Title")
    
    return DataModel(listOf(
            DataModel.Data("header",header),
            DataModel.Data("body",body),
            DataModel.Data("footer",footer)
    ))
}

