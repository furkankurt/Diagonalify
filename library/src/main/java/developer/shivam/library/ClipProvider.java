package developer.shivam.library;

import android.graphics.Path;

public class ClipProvider {

    private static float SHADOW_CORRECTION = 10f;
    private static int ALPHA = 1;

    /**
     * @param width width of imageView excluding padding
     * @param height height of imageView excluding padding
     * @param angle angle at which diagonal is to be formed
     * @param horizontalShift horizontal shift from the x-axis.
     * @return path for clipping imageView
     */
    public static Path getDiagonalCutPath (int width, int height, int angle, int horizontalShift, int gravity,
                                           int paddingLeft, int paddingRight, int paddingTop, int paddingBottom) {

        float perpendicularHeight = (float) (width * Math.tan(Math.toRadians(angle)));

        Path mPath = new Path();

        if ((gravity & DiagonalView.TOP) != DiagonalView.TOP) {
            if ((gravity & DiagonalView.LEFT) == DiagonalView.LEFT) {
                mPath.moveTo(paddingLeft, height - paddingBottom);
                if (horizontalShift > 0 && horizontalShift < width) {
                    mPath.lineTo(horizontalShift + paddingLeft, height - paddingBottom);
                }
                mPath.lineTo(width - paddingRight, height - perpendicularHeight - paddingBottom);
                mPath.lineTo(width - paddingRight, height + ALPHA + paddingTop);
                mPath.lineTo(paddingLeft, height + ALPHA + paddingTop);
                mPath.close();
            } else {
                mPath.moveTo(width - paddingLeft, height - paddingBottom);
                if (horizontalShift > 0 && horizontalShift < width) {
                    mPath.lineTo(horizontalShift - paddingLeft, height - paddingBottom);
                }
                mPath.lineTo(paddingRight, height - perpendicularHeight - paddingBottom);
                mPath.lineTo(paddingRight, height + ALPHA + paddingTop);
                mPath.lineTo(width - paddingLeft, height + ALPHA + paddingTop);
                mPath.close();
            }
        } else {
            if ((gravity & DiagonalView.LEFT) == DiagonalView.LEFT) {
                mPath.moveTo(paddingLeft, perpendicularHeight - paddingTop - paddingBottom);
                if (horizontalShift > 0 && horizontalShift < width) {
                    mPath.lineTo(horizontalShift + paddingLeft, perpendicularHeight - paddingTop - paddingBottom);
                }
                mPath.lineTo(width - paddingRight, paddingBottom + paddingTop);
                mPath.lineTo(width - paddingRight, ALPHA);
                mPath.lineTo(paddingLeft, ALPHA);
                mPath.close();
            } else {
                mPath.moveTo(paddingLeft, paddingTop);
                if (horizontalShift > 0 && horizontalShift < width) {
                    mPath.lineTo(horizontalShift + paddingLeft, paddingTop);
                }
                mPath.lineTo(width - paddingRight, perpendicularHeight - paddingBottom - paddingTop);
                mPath.lineTo(width - paddingRight, ALPHA);
                mPath.lineTo(paddingLeft, ALPHA);
                mPath.close();
            }
        }
        return mPath;
    }

    /**
     * @param width width of imageView excluding padding
     * @param height height of imageView excluding padding
     * @param angle angle at which diagonal is to be formed
     * @param horizontalShift horizontal shift from the x-axis.
     * @return path for clipping imageView
     */
    public static Path getDiagonalOutlinePath (int width, int height, int angle, int horizontalShift, int gravity,
                                               int paddingLeft, int paddingRight, int paddingTop, int paddingBottom) {

        float perpendicularHeight = (float) (width * Math.tan(Math.toRadians(angle)));

        Path mPath = new Path();
        if ((gravity & DiagonalView.TOP) == DiagonalView.TOP) {
            if ((gravity & DiagonalView.LEFT) == DiagonalView.LEFT) {
                mPath.moveTo(paddingLeft, height - paddingBottom);
                if (horizontalShift > 0 && horizontalShift < width) {
                    mPath.lineTo(horizontalShift + paddingLeft, height - paddingBottom);
                }
                mPath.lineTo(width - paddingRight, height - perpendicularHeight - paddingBottom);
                mPath.lineTo(width - paddingRight, paddingTop);
                mPath.lineTo(paddingLeft, paddingTop);
                mPath.close();
            } else {
                mPath.moveTo(width - paddingLeft, height - paddingBottom);
                if (horizontalShift > 0 && horizontalShift < width) {
                    mPath.lineTo(horizontalShift - paddingLeft, height - paddingBottom);
                }
                mPath.lineTo(paddingRight, height - perpendicularHeight - paddingBottom);
                mPath.lineTo(paddingRight, paddingTop);
                mPath.lineTo(width - paddingLeft, paddingTop);
                mPath.close();
            }
        } else {
            if ((gravity & DiagonalView.LEFT) == DiagonalView.LEFT) {
                mPath.moveTo(paddingLeft, perpendicularHeight);
                if (horizontalShift > 0 && horizontalShift < width) {
                    mPath.lineTo(horizontalShift + paddingLeft, height - paddingBottom);
                }
                mPath.lineTo(width - paddingRight, height - perpendicularHeight - paddingBottom);
                mPath.lineTo(width - paddingRight, paddingTop);
                mPath.lineTo(paddingLeft, paddingTop);
                mPath.close();
            } else {
                mPath.moveTo(width - paddingLeft, height - paddingBottom);
                if (horizontalShift > 0 && horizontalShift < width) {
                    mPath.lineTo(horizontalShift - paddingLeft, height - paddingBottom);
                }
                mPath.lineTo(paddingRight, height - perpendicularHeight - paddingBottom);
                mPath.lineTo(paddingRight, paddingTop);
                mPath.lineTo(width - paddingLeft, paddingTop);
                mPath.close();
            }
        }
        return mPath;
    }
}
