package ua.edu.cdu.boris.fiveqadricsurfaces;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;

import io.github.kexanie.library.MathView;
import ua.edu.cdu.boris.fiveqadricsurfaces.surfeces.*;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private QuadricSurface quadricSurface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RadioButton btnEllipsoid = (RadioButton) findViewById(R.id.btnEllipsoid);
        RadioButton btnOneHyperboloid = (RadioButton) findViewById(R.id.btnOneHyperboloid);
        RadioButton btnTwoHyperboloid = (RadioButton) findViewById(R.id.btnTwoHyperboloid);
        RadioButton btnEllipticParaboloid = (RadioButton) findViewById(R.id.btnEllipticParaboloid);
        RadioButton btnHyperbolicParaboloid = (RadioButton) findViewById(R.id.btnHyperbolicParaboloid);

        Button btnViewDetail = (Button) findViewById(R.id.btnViewDetail);

        assert btnEllipsoid != null;
        btnEllipsoid.setOnClickListener(this);
        assert btnOneHyperboloid != null;
        btnOneHyperboloid.setOnClickListener(this);
        assert btnTwoHyperboloid != null;
        btnTwoHyperboloid.setOnClickListener(this);
        assert btnEllipticParaboloid != null;
        btnEllipticParaboloid.setOnClickListener(this);
        assert btnHyperbolicParaboloid != null;
        btnHyperbolicParaboloid.setOnClickListener(this);

        assert btnViewDetail != null;
        btnViewDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentDetail = new Intent(Intent.ACTION_VIEW, Uri.parse(quadricSurface.getWikiLink(MainActivity.this)));
                if (getPackageManager().queryIntentActivities(intentDetail, 0).size() > 0) {
                    startActivity(intentDetail);
                }
            }
        });

        quadricSurface = new Ellipsoid();
        setAllElements();
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.btnEllipsoid:
                quadricSurface = new Ellipsoid();
                break;
            case R.id.btnOneHyperboloid:
                quadricSurface = new OneSheetHyperboloid();
                break;
            case R.id.btnTwoHyperboloid:
                quadricSurface = new TwoSheetsHyperboloid();
                break;
            case R.id.btnEllipticParaboloid:
                quadricSurface = new EllipticParaboloid();
                break;
            case R.id.btnHyperbolicParaboloid:
                quadricSurface = new HyperbolicParaboloid();
                break;
        }
        setAllElements();
    }

    private void setAllElements() {
        ImageView ivPicture = (ImageView) findViewById(R.id.ivPicture);
        MathView mvFormula = (MathView) findViewById(R.id.mvFormula);

        assert ivPicture != null;
        ivPicture.setImageResource(quadricSurface.getPicture());
        assert mvFormula != null;
        mvFormula.setText(quadricSurface.getFormula());
    }

    @Override
    protected void onResume() {
        super.onResume();
        setAllElements();
    }
}
