package pl.monku._99

import org.hamcrest.BaseMatcher
import org.hamcrest.Description


class ContainsAll<T>(private val list: List<T>) : BaseMatcher<List<T>>() {


    override fun describeTo(description: Description) {
        description.appendText("Expected value containing all: ").appendValue(list)
    }

    override fun matches(item: Any?): Boolean {
        if(item is List<*>)
        {
            return item.containsAll(list) && item.size == list.size
        }
        return false
    }
}