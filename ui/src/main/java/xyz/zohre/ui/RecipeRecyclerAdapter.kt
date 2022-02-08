package xyz.zohre.ui

import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import kotlinx.android.synthetic.main.item_recipe.view.*
import xyz.zohre.data.model.Recipe
import xyz.zohre.presentation.adapter.BaseRecyclerAdapter
import xyz.zohre.presentation.adapter.BaseViewHolder
import xyz.zohre.presentation.bindImage

class RecipeRecyclerAdapter:
    BaseRecyclerAdapter<Recipe,
            RecipeRecyclerAdapter.ViewHolder,
            BaseViewHolder.OnItemClickListener<Recipe>>(){


    override fun viewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent?.context).inflate(
                R.layout.item_recipe,
                parent,
                false
            ),
            this
        )
    }

    override fun onBindView(holder: ViewHolder?, position: Int) {
        holder?.bind(data[position])
    }

    class ViewHolder(itemView: View,
                     adapter: RecipeRecyclerAdapter,)
        : BaseViewHolder<Recipe>(itemView, adapter){
        override fun bind(t: Recipe) {
            t.name.also { itemView.name.text = it }
            t.headline.also { itemView.headLine.text = it }

            bindImage(
                imageUrl = t.image,
                imageView = itemView.image,
                listener = object : RequestListener<Drawable> {

                    override fun onResourceReady(
                        resource: Drawable?,
                        model: Any?,
                        target: Target<Drawable>?,
                        dataSource: DataSource?,
                        isFirstResource: Boolean
                    ): Boolean {
                        return false
                    }

                    override fun onLoadFailed(
                        e: GlideException?,
                        model: Any?,
                        target: Target<Drawable>?,
                        isFirstResource: Boolean
                    ): Boolean {
                        return false
                    }
                }
            )

        }

    }
}