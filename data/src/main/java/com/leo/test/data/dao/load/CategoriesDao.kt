package com.leo.test.data.dao.load

/**
 * @date 2018/9/3
 * @author leo,ZhangWei
 * @function
 */
class CategoriesDao {

    var error: Boolean? = null
    var results: List<CategoriesData>? = null

    class CategoriesData {
        var _id: String? = null
        var en_name: String? = null
        var name: String? = null
        var rank: Int? = null
        override fun toString(): String {
            return "CategoriesData(_id=$_id, en_name=$en_name, name=$name, rank=$rank)"
        }


    }

    override fun toString(): String {
        return "CategoriesDao(error=$error, results=$results)"
    }


}