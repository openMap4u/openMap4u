package org.openmap4u.builder;

import java.awt.geom.Point2D;
import java.util.HashSet;
import java.util.Set;
import org.openmap4u.commons.DrawableTransformable;
import org.openmap4u.commons.Plugable;
import org.openmap4u.commons.Position;
import org.openmap4u.primitive.Drawable;
import org.openmap4u.style.Styleable;

import org.openmap4u.unit.Angle;
import org.openmap4u.unit.Transparence;

/**
 * All builders are derived from this base class.
 *
 * @author Michael Hadrbolec
  * @param <S> The style type.
 * @param <B> The builder type.
 */
public class Buildable<S extends Styleable<S>, B extends Buildable<S, B>> implements Drawable<S>, Plugable {

    /**
     * Stores the angle units.
     */
    private Angle mAngleUnits = Angle.DEGREE;
    
      /**
     * Stores the transparence units.
     */
    private Transparence mTransparence = Transparence.PERCENT;
    
    private S mStyle = null;


    /**
     * Stores the points.
     */
    private Set<Object> mPoints = null;

    /**
     * Gets the points.
     *
     * @return The points.
     */
    public Set<Object> getPoints() {
        return this.mPoints;
    }

    /**
     * Used to create the individual transformation.
     */
    private DrawTransform mTransform = new DrawTransform();

    Buildable(){} 

    /**
     * Sets whether the primitive is visible.
     *
     * @param isVisible The visibility.
     * @return The builder itself.
     */
    public B visible(boolean isVisible) {
        getStyle().setVisible(isVisible);
        return (B) this;
    }

    /**
     * Sets the transparence.
     *
     * @param tranparence The transparence.
     * @return
     */
    public B transparence(double tranparence) {
        getStyle().setAlpha(mTransparence.convert(tranparence));
        return (B) this;
    }

    public B align(Position align) {
        this.getTransform().setAlign(align);
        return (B) this;
    }

    /**
     * Sets the offset in darwing units.
     * @param offsetX The x offset in drawing units.
     * @param offsetY The y offset in drawing units.
     * @return The builder itself (method chaining pattern).
     */
    public final B offset(double offsetX, double offsetY) {
        this.mTransform.setOffset(new Point2D.Double(offsetX,offsetY));
        return (B) this;
    }

    public final B offsetX(double offsetX) {
        return offset(offsetX, this.mTransform.getOffset().getY());
    }

    public final B offsetY(double offsetY) {
        return offset(this.mTransform.getOffset().getX(),offsetY);
    }

    public final B scale(double scaleFactor) {
        return scale(scaleFactor, scaleFactor);
    }

    public final B scale(double scaleX, double scaleY) {
        scaleX(scaleX);
        scaleY(scaleY);
        return (B) this;
    }

    public final B scaleX(double scaleX) {
        this.mTransform.setScaleX(scaleX);
        return (B) this;
    }

    public final B scaleY(double scaleY) {
        this.mTransform.setScaleY(scaleY);
        return (B) this;
    }

    public final B rotate(double angle) {
        this.mTransform.setRotate(this.mAngleUnits.convert(angle));
        return (B) this;
    }

    /**
     * initializes the points.
     */
    private B addPoint(Object point2Add) {
        if (this.mPoints == null) {
            this.mPoints = new HashSet<>();
        }
        this.mPoints.add(point2Add);
        return (B) this;
    }

    public final B point(double x, double y) {
        return addPoint(new Point2D.Double(x, y));
    }

    public final B point(Position position) {
        return addPoint(position);
    }

    /**
     * Gets the built primitive.
     *
     * @return The build (=resultin) primitive.
     */
    

    @Override
    public final S getStyle() {
        return this.mStyle;
    }
    
     @Override
    public final void setStyle(S style) {
         this.mStyle=style;
    }

    @Override
    public final DrawableTransformable getTransform() {
        return this.mTransform;
     }

    /**
     * Wheter it is a point (=true) or not (=false).
     * @return 
     */
    public boolean isPoint() {
       return this.getPoints()!=null && this.getPoints().size()>0;
    }

}
