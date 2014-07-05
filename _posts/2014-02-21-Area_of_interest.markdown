---
layout: post
title:  "Align, offset, rotate and or scale!"
date:   2014-02-21 21:37:00
categories: jekyll update
---

You'll find this post in your `_posts` directory - edit this post and re-build (or run with the `-w` switch) to see your changes!
To add new posts, simply add a file in the `_posts` directory that follows the convention: YYYY-MM-DD-name-of-post.ext.


# Draw a line
===========
# Draw a line
===========


# Draw point
==========
A point has no extent. So you cannot see ist. Therefore it is necessary to visualize it either with a line, a polygon, an image or an text at the points position.

## Draw a "text" point
{% highlight java %}
/* 1. get an openMap4u instance */
OpenMap4u oM4u = new OpenMap4u();
/* 2. get an canvas and specify the size which you want to draw */
DrawOrWriteable canvas = oM4u.getCanvas(10, 2);
/* draw the text primitive */
canvas.draw(oM4u.get(Text.class).text("Hello World").point(.5, .5));
/* write the result */
canvas.write(getPackagePath("simpleText.png"));
{% endhighlight %}

This results in: 
![My helpful screenshot]({{ site.url }}/assets/simpleText.png)


## Draw an "image" point
{% highlight java %}
/* 1. get an openMap4u instance */
OpenMap4u oM4u = new OpenMap4u();
/* 2. get an canvas and specify the size which you want to draw */
DrawOrWriteable canvas = oM4u.getCanvas(10, 2);
/* draw the text primitive */
canvas.draw(oM4u.get(Image.class).path("Hello World").point(.5, .5));
/* write the result */
canvas.write(getPackagePath("simpleImage.png"));
{% endhighlight %}

---------------------
## Draw an "line" point
---------------------
## Draw an "polygon" point
---------------------


 

![My helpful screenshot]({{ site.url }}/assets/simpleText.png)


# Draw a Line primitive:

{% highlight java %}
/* 1. get an openMap4u instance */
OpenMap4u oM4u = new OpenMap4u();
/* 2. get an canvas and specify the size which you want to draw */
DrawOrWriteable canvas = oM4u.getCanvas(10, 2);
/* draw the text primitive */
canvas.draw(oM4u.get(Line.class).line(.5,.5,1.5,.75));
/* write the result */
canvas.write(getPackagePath("simpleLine.png"));
{% endhighlight %}

![My helpful screenshot]({{ site.url }}/assets/simpleText.png)

# Draw a polyline primitive:

{% highlight java %}
/* 1. get an openMap4u instance */
OpenMap4u oM4u = new OpenMap4u();
/* 2. get an canvas and specify the size which you want to draw */
DrawOrWriteable canvas = oM4u.getCanvas(10, 2);
/* draw the text primitive */
canvas.draw(oM4u.get(Polyline.class).lineTo(.5,.5).lineTo(1,.75).lineTo(1.5,.25));
/* write the result */
canvas.write(getPackagePath("simplePolyline.png"));
{% endhighlight %}

![My helpful screenshot]({{ site.url }}/assets/simpleText.png)

Draw a polygon primitive:

{% highlight java %}
/* 1. get an openMap4u instance */
OpenMap4u oM4u = new OpenMap4u();
/* 2. get an canvas and specify the size which you want to draw */
DrawOrWriteable canvas = oM4u.getCanvas(10, 2);
/* draw the text primitive */
canvas.draw(oM4u.get(Text.class).text("Hello World").size(3).point(.5, .5));
/* write the result */
canvas.write(getPackagePath("simpleText.png"));
{% endhighlight %}

![My helpful screenshot]({{ site.url }}/assets/simpleText.png)

Draw a image primitive:

{% highlight java %}
/* 1. get an openMap4u instance */
OpenMap4u oM4u = new OpenMap4u();
/* 2. get an canvas and specify the size which you want to draw */
DrawOrWriteable canvas = oM4u.getCanvas(10, 2);
/* draw the text primitive */
canvas.draw(oM4u.get(Text.class).text("Hello World").size(3).point(.5, .5));
/* write the result */
canvas.write(getPackagePath("simpleText.png"));
{% endhighlight %}

![My helpful screenshot]({{ site.url }}/assets/simpleText.png)


Check out the [Jekyll docs][jekyll] for more info on how to get the most out of Jekyll. File all bugs/feature requests at [Jekyll's GitHub repo][jekyll-gh].

[jekyll-gh]: https://github.com/mojombo/jekyll
[jekyll]:    http://jekyllrb.com
