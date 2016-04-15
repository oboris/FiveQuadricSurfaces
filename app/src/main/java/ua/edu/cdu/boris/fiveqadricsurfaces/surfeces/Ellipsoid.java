package ua.edu.cdu.boris.fiveqadricsurfaces.surfeces;

import android.content.Context;

import ua.edu.cdu.boris.fiveqadricsurfaces.R;

public class Ellipsoid extends QuadricSurface {

    public Ellipsoid() {}

    @Override
    public String getFormula() {
        return "$$\\frac{x^2}{a^2}+\\frac{y^2}{b^2}+\\frac{z^2}{c^2}=1$$";
    }

    @Override
    public int getPicture() {
        return R.drawable.ellipisoid;
    }

    @Override
    public String getWikiLink(Context context) {
        return context.getString(R.string.detailEllipsoid);
    }
}
