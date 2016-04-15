package ua.edu.cdu.boris.fiveqadricsurfaces.surfeces;

import android.content.Context;

import ua.edu.cdu.boris.fiveqadricsurfaces.R;

public class EllipticParaboloid extends QuadricSurface {

    public EllipticParaboloid(){}

    @Override
    public String getFormula() {
        return "$$\\frac{x^2}{a^2}+\\frac{y^2}{b^2}-z=0$$";
    }

    @Override
    public int getPicture() {
        return R.drawable.elliptic_paraboloid;
    }

    @Override
    public String getWikiLink(Context context) {
        return context.getString(R.string.detailParaboloid);
    }
}
