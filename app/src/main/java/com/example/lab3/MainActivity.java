package com.example.lab3;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

/**
 * MainActivity - Écran de saisie.
 * Réalisé par Mouad Charraj (Z3R0-XR7).
 */
public class MainActivity extends AppCompatActivity {

    // Déclaration des variables (L'erreur "Cannot resolve symbol" indique souvent un problème de synchro R)
    private EditText nom_mouad;
    private EditText email_mouad;
    private EditText phone_mouad;
    private EditText adresse_mouad;
    private EditText ville_mouad;
    private Button btnEnvoyer_mouad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // On lie le layout XML
        setContentView(R.layout.activity_main);

        // Initialisation des vues via leurs IDs (Suffixe mouad)
        nom_mouad = findViewById(R.id.nom_mouad);
        email_mouad = findViewById(R.id.email_mouad);
        phone_mouad = findViewById(R.id.phone_mouad);
        adresse_mouad = findViewById(R.id.adresse_mouad);
        ville_mouad = findViewById(R.id.ville_mouad);
        btnEnvoyer_mouad = findViewById(R.id.btnEnvoyer_mouad);

        // Gestion du clic sur le bouton d'envoi
        if (btnEnvoyer_mouad != null) {
            btnEnvoyer_mouad.setOnClickListener(v -> {
                // Lecture et nettoyage des données (Style Z3R0-XR7)
                String sNom = (nom_mouad != null) ? nom_mouad.getText().toString().trim() : "";
                String sEmail = (email_mouad != null) ? email_mouad.getText().toString().trim() : "";
                String sPhone = (phone_mouad != null) ? phone_mouad.getText().toString().trim() : "";
                String sAds = (adresse_mouad != null) ? adresse_mouad.getText().toString().trim() : "";
                String sVil = (ville_mouad != null) ? ville_mouad.getText().toString().trim() : "";

                // Validation minimale
                if (sNom.isEmpty() || sEmail.isEmpty()) {
                    Toast.makeText(this, "Champs obligatoires manquants !", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Passage à l'activité suivante (AffichageActivityMouad)
                Intent intent = new Intent(this, AffichageActivityMouad.class);
                intent.putExtra("nom", sNom);
                intent.putExtra("email", sEmail);
                intent.putExtra("phone", sPhone);
                intent.putExtra("adresse", sAds);
                intent.putExtra("ville", sVil);

                startActivity(intent);
            });
        }
    }
}
