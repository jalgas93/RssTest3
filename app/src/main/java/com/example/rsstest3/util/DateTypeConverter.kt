package com.example.rsstest3.util

import androidx.room.TypeConverter
import com.example.rsstest3.model.Image
import java.time.LocalDate

class DateTypeConverter {

    companion object {


        @TypeConverter
        @JvmStatic
        fun image(image: Image): String {
            return image.url!!
            //return image.title
            //return image.description
            //return image.link
            //return image.url
        }

        @TypeConverter
        @JvmStatic
        fun Image2(image: String): Image {
            return Image(

                title = image,
                description = image,
                url = image,
                link = image
            )
        }
    }

}
