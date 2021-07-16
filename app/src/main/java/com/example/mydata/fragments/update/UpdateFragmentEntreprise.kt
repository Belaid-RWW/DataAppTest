package com.example.mydata.fragments.update

import android.app.AlertDialog
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.mydata.R
import com.example.mydata.model.Entreprise
import com.example.mydata.viewmodel.EntrepriseViewModel
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.android.synthetic.main.fragment_add_immeuble.view.*
import kotlinx.android.synthetic.main.fragment_update_entreprise.*
import kotlinx.android.synthetic.main.fragment_update_entreprise.view.*

class UpdateFragmentEntreprise : Fragment() {

    private lateinit var mEntrepriseViewModel: EntrepriseViewModel

    lateinit var dom: String
    lateinit var act: String
    lateinit var hor_deb: String
    lateinit var hor_fin: String


    private val args by navArgs<UpdateFragmentEntrepriseArgs>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_update_entreprise, container, false)

        mEntrepriseViewModel = ViewModelProvider(this).get(EntrepriseViewModel::class.java)

        dom= ""
        act = ""
        hor_deb = ""
        hor_fin = ""

        var domList = arrayOf("Restauration et cafés" ,"Auto, Moto", "Coiffure et soins de beauté", "Sport, loisir et divertissement",
                "Culture et arts", "Santé", "Alimentation", "Matériel et équipments de construction", "BTP", "Service spécialisé scientifique et technique",
                "Service B2B", "Réparation et service aux personnes", "Tourisme", "Droit et justice", "Education et enseignement",
                "Banque, finance, assurance", "Immoblier", "Transport et logistique", "Réligion", "Magasin spécialisé - Meuble",
                "Magasin spécialisé - Vêtements", "Magasin spécialisé - Sports", "Magasin spécialisé - Informatique et télécommunications",
                "Magasin spécialisé - Eléctroniques", "Magasin spécialisé - TV et Audio", "Magasin spécialisé - Matériels audio/vidéo",
                "Magasin spécialisé - Matériels de sécurité et surveillance", "Magasin spécialisé - Récepteurs et paraboles", "Magasin spécialisé - Consoles et jeux vidéos",
                "Magasin spécialisé - Horlogerie", "Magasin spécialisé - Bijoux", "Magasin spécialisé - Instruments et matériels du musique",
                "Magasin spécialisé - Produits artisanals et souvenirs", "Magasin spécialisé - Cigarettes éléctroniques et accessoires", "Magasin spécialisé - Article d'emballage et packaging",
                "Magasin spécialisé - Article de pâtisserie", "Magasin spécialisé - Zoomagasin - Animalerie", "Magasin spécialisé - Articles en plastiques","Magasin spécialisé - Equipements de pêche",
                "Magasin spécialisé - Equipements de chasse", "Magasin spécialisé - Biens d'antiquité et de brocante", "Magasin spécialisé - Biens d'occasion",
                "Magasin spécialisé - Equipements des restaurents et cafés", "Magasin spécialisé - Parfumerie", "Magasin spécialisé - Parfumerie Professionnel", "Magasin spécialisé - Matériel et équipement de salon de coiffure",
                "Magasin spécialisé - Jeux et jouets", "Magasin spécialisé - Maison")

        val dom : AutoCompleteTextView =  view.findViewById(R.id.updateDom)
        val adapter3: ArrayAdapter<String> = ArrayAdapter<String>(requireContext(), android.R.layout.simple_list_item_1, domList)
        dom.setAdapter(adapter3)
        dom.threshold=0

        var actList = arrayOf("Restaurant touristique ", "Restaurant", "Restaurant grillade ", "Sandwicherie",
                "Pizzaria", "Restaurant populaire", "Fastfood", "Sushi",
                "Services des traiteurs", "Restaurant Bar", "Salon de Thé", "Café",
                "Cafétéria ", "Glaces", "Jus et smoothies", "Electricité automobile",
                "Mécanique générale", "Tôlerie et peinture", "Entretien et Révision", "Contrôle et Diagnostic auto",
                "Équilibrage des roues ", "Réparation des pneus ", "Réglage Parallélisme", "Jantes - Roues Complètes",
                "Réparation d'échappement automobile", "Remplacement et Réparation pare-brise", "Réparation des injecteurs automobiles", "Concessionnaire Automobile",
                "Réparation de motocycles", "Commerce de motocycles", "Commerce de gros de pièces de rechange automobiles", "Commerce de détail pièces de rechange  automobiles",
                "Commerce de détail pièces de rechange motocycles ", "Commerce de gros pièces de rechange  motocycles ", "Station de service ", "Lavage automobile ",
                "Commerce d'accessoires automobiles ", "Tapissier auto", "Vente voitures d'occasion ", "Tuning ",
                "Instalation de système de géolocalistion pour voiture ", "Moto et bicyclette d'occasion ", "Salon de coiffure ", "Salon de coiffure pour femme ",
                "Salon de coiffure pour homme ", "Centre d'esthétique", "Soins pour cheveux ", "Onglerie",
                "Centre de massage", "Centre de SPA ", "Salon de tatouage ", "Soin des Cils et sourcils ","Centre d'amincissement ","Hammam",
                "Salle de fitness", "Salle de gym", "Complexe sportif", "Location de terrain de football", "Club de danse", "Club de yoga ", "Club de tennis ",
                "Location terrain de tennis", "Club de natation", "Club de gymnastique", "Club des arts martiaux et sport de défense ",
                "Club d'équitation", "Terrain de golf ", "Salle de jeux", "Salle de billard", "Parc de jeux pour enfant", "Bowling", "Aquapark",
                "Zoo", "Plage aménagé", "Base nautique", "Cinéma", "Boite de nuit", "Resto-lounge", "Cabaret", "Port de plaisance", "Club d'internet",
                "Club de jeux vidéo", "Club vidéo", "Location vélo", "Club de plongée sous marine", "Théâtre ", "Musée", "Bibliothèque",
                "Centre culturel", "Librairie culturel", "Galerie d'expositions culturelles", "Hôpital", "Polyclinique", "Centre de santé de base",
                "Pharmacie", "Centre d'analyses médicales ", "Centre d'imagerie médicale et de radiologie", "Médecin spécialiste en imagerie médicale",
                "Cabinet de kinésithérapie et rééducation fonctionnelle", "Parapharmacie", "Dentiste", "Pédiatre", "Stomatologie et chirurgie maxillo faciale",
                "Médecin spécialiste en anatomie Et Cytologie Pathologique", "Anesthésiste-Réanimateur", "Médecin en biologie médical", "Médecin Spécialiste en Oncologie Médicale",
                "Médecin cardiologue", "Chirurgien Cardio-Vasculaire", "Médecin en chirurgie générale", "Médecin en chirurgie neurologique",
                "Médecin en chirurgie orthopédique et traumatologique", "Médecin en chirurgie pédiatrique", "Médecin en chirurgie plastique réparatrice et esthétique", "Médecin en chirurgie thoracique",
                "Médecin en chirurgie urologique", "Médecin en chirurgie vasculaire périphérique", "Médecin en dermatologie/ Dermatologue", "Médecin en Endocrinologie / Endocrinologue",
                "Médecin en gastro-entérologie / Gastro Entérologue", "Médecin en gynécologie obstétrique", "Médecin en médecine de famille ", "Médecin générale",
                "Médecin en médecine physique et de réadaptation", "Médecin en néphrologie / néphrologue", "Médecin en ophtalmologie / ophtalmologue", "Médecin en Oto Rhino Laryngologie / ORL",
                "Pédopsychiatre", "Médecin en physiologie exploration fonctionnelle", "Médecin en pneumologie / Pneumologue ", "Psychiatre",
                "Médecin en radiothérapie carcinologique", "Médecin en rhumatologie / Rhumatologue", "Médecin en urologie / Urologue", "Orthodontiste",
                "Orthophoniste ", "Orthoptiste", "Opticien", "Laboratoire de prothése dentaire", "Podologue", "Vétérinaire", "Infirmerie",
                "Diététicien", "Audioprothésiste", "Ambulancier", "Chiropracteur", "Vente matériels médicals et paramédicals ", "Centres de médecine sportive",
                "Centre d'exploration fonctionnelle ORL", "Meuble de maison", "Meuble de bureau", "Meuble de cuisine", "Meuble personnalisé",
                "Oreillers et Matelas", "Meuble de jardin", "Meuble en fer forgé", "Meuble d'occasion", "Vêtements pour femme", "Vêtements pour homme",
                "Vêtements pour enfant ", "Vêtements pour bébé", "Vêtements pour femme enceinte", "Vêtements en cuir", "Vêtements de grande taille ",
                "Vêtements traditionnels et artisanals ", "Sacs et accessoires", "Chaussures pour homme", "Chaussures pour femme",
                "Chaussures pour enfant ", "Chaussures pour bébé", "Robes de mariée", "Location de robes de mariée", "Tenues de soirée pour femme",
                "Location de tenues de soirée", "Friperie", "Vêtements de déguisements", "Vêtements de travail", "Vêtements de sport",
                "Nutrition sportive", "Restaurant", "Equipement et matériel de sport ", "Équipements informatique et multimédia ",
                "Équipements informatique et multimédia avec maintenance ", "Téléphones et accessoires ", "Téléphones et accessoires avec maintenance", "Literie et linge de maison",
                "Tissus", "Electroménager", "Couverts vaisselles et accessoires", "Décoration de maison", "Produits de nettoyage ", "Tapis et moquettes",
                "Fleurs et plantes de décoration", "Épicerie", "Épicerie fine", "Supérette", "Supermarché", "Marché", "Fruits et légumes",
                "Boucherie", "Poissonnier", "Boulangerie", "Volailles ", "Boulangerie et pâtisserie ", "Pâtisserie", "Croissanterie",
                "Confiserie", "Drugstore ", "Produits laitiers", "Fromagerie", "Produits diététiques et Bio", "Fruits secs", "Epices et huiles", "Chocolats",
                "Tabac", "Commerce de gros de boissons", "Commerce de gros de produits alimentaires", "Commerce de boissons alcooliques",
                "Quincaillerie", "Sanitaires ", "Revêtements sols et murs", "Matériaux de construction ", "Équipements de chantier ", "Isolation et étanchéité ",
                "Électricité bâtiment", "Éclairage et lumière ", "Climatisation et aération", "Panneaux solaires / Énergie solaire photovoltaïque",
                "Piscine et jacuzzi", "Réseaux et télécommunications ", "Sécurité et surveillance ", "Ascenseurs", "Protection incendie ",
                "Engins de chantier ", "Entreprise générale de bâtiment ", "Travaux d'étanchéité", "Matériel de construction", "Travaux de peinture",
                "Travaux d'électricité", "Marbre", "Bois", "Rideaux et stores ", "Travaux de plomberie sanitaire et robinetterie ",
                "Travaux de fer forgé et serrurerie", "Travaux de pose de carreaux et de mosaïque", "Travaux de pose de faux plafond", "Travaux de plâtrerie",
                "Instalation de stores et rideaux ", "Travaux de charpente métallique", "Menuiserie en PVC", "Menuiserie en aluminium",
                "Menuiserie en bois", "Travaux de sécurité incendie", "Installation des ascenseurs ", "Installation sanitaires et fluides",
                "Installation climatisation ", "Entreprise des travaux publics ", "Travaux de verrerie et cadre", "Architecte", "Expert géomètre",
                "Contrôleur technique", "Bureaux d'études agréés", "Ingénieur conseil", "Expert comptable", "Comptable", "Commissaire aux comptes",
                "Traducteur et interprète", "Agences de publicité", "Conseil pour les affaires et conseils de gestion", "Topographe",
                "Architecte d'intérieur ", "Assistance comptable", "Laboratoire d'analyses agro-alimentaires ", "Paysagiste ", "Photocopie, traitement et rédaction de texte",
                "Bureaux d'études spécialisés dans le domaine de l’environnement", "Services en développement informatiques", "Impressions et tirages grands formats ", "Studio de photographie publicitaire ",
                "Studio de photographe", "Laboratoire photo", "Intermédiaire pour les études à l'étranger ", "Graphiste ", "Marketing digital ",
                "Agence de communication ", "Plaques d'immatriculation et enseignes", "Service d'hygiène et désinfection ", "Salle des fêtes",
                "Agence d'intérim et de recrutement ", "Opérateur de télécommunications", "Fournisseur d'accés à inernet ", "Régie publicitaire de médias",
                "Salle de réunion et congrés", "Agence de communication", "Centre d'appel", "Organisation de salons professionnels et congrès",
                "Buanderie industrielle", "Agence publicitaire", "Marketing et étude de marché ", "Coworking space", "Conseiller pour les entreprises ",
                "Téléphones et accessoires en gros ", "Électroménager en gros", "Équipements informatique et multimédia en gros", "Conseiller fiscal",
                "Tailleur", "Tailleur pour femmes ", "Réparation de produits électroniques", "Réparation d'appareils électroménagers", "Réparation de chaussures et d'articles en cuir",
                "Réparation de meubles", "Services funéraires", "Réparation d'ordinateurs et d'équipements périphériques", "Réparation d'équipements de communication",
                "Pressing", "Réparation d'articles d'horlogerie", "Réparation d'articles de bijouterie", "Réparation d'autres biens personnels et domestiques",
                "Tapissier", "Réparation de serrures et fabrication de clés", "Hôtel", "Agence de voyage ", "Centre de Thalasso",
                "Avocat", "Huissier ", "Notaire ", "Centre d'arbitrage", "Crèche d'enfants", "Garderie d'enfants ", "Jardin d'enfants",
                "École", "École privée", "Collège ", "Collège privé", "Lycée privé", "Lycée", "Établissement d'enseignement supérieur ",
                "Établissement d'enseignement supérieur privé", "Centre de formation professionnelle", "Auto-école", "Conservatoire de musique ",
                "Soutien scolaire", "Agence bancaire", "Direction régionale banque ", "DAB GAB", "Agence d'assurance ", "Direction régionale d'assurance",
                "Bureau de change", "Agence de Leasing ", "Intermédiaire en bourse ", "Microcrédit / Microfinance ", "Société de recouvrement des créances ",
                "Promoteur immobilier", "Syndic immobilier professionnel ", "Agence immobilière", "Services auxiliaires des transports aériens",
                "Transport ferroviaire interurbain de voyageurs", "Transports ferroviaires de fret", "Transports urbains et suburbains de voyageurs", "Transports de voyageurs par taxis et par louage",
                "Autres activités de poste et de courrier", "Manutention", "Services auxiliaires des transports par eau", "Services auxiliaires des transports terrestres",
                "Entreposage et stockage non frigorifique", "Entreposage et stockage frigorifique", "Activités de poste dans le cadre d'une obligation de service universel", "Transports aériens de fret",
                "Transports spatiaux", "Transports fluviaux de fret", "Autres services auxiliaires des transports", "Transports fluviaux de passagers",
                "Transports maritimes et côtiers de fret", "Transports maritimes et côtiers de passagers", "Transports par conduites", "Services de déménagement",
                "Transports routiers de fret", "Autres transports terrestres de voyageurs n.c.a", "Autres transports terrestres réguliers de voyageurs, interurbain", "Transports aériens de passagers",
                "Transports aériens de passagers", "Location de voiture avec ou sans chauffeur", "Fournitures bureautiques et informatiques en gros", "Fournitures bureautiques et informatiques "
        )

        val act : AutoCompleteTextView =  view.findViewById(R.id.updateAct)
        val adapter4: ArrayAdapter<String> = ArrayAdapter<String>(requireContext(), android.R.layout.simple_list_item_1, actList)
        act.setAdapter(adapter4)
        act.threshold=0

        var debList = arrayOf("07:00","08:00", "09:00","10:00", "11:00", "12:00")
        val hor1 : AutoCompleteTextView =  view.findViewById(R.id.updateHorDeb)
        val adapter1: ArrayAdapter<String> = ArrayAdapter<String>(requireContext(), android.R.layout.simple_list_item_1, debList)
        hor1.setAdapter(adapter1)
        hor1.threshold=0

        var finList = arrayOf("13:00", "14:00","15:00", "16:00", "17:00", "18:00", "19:00", "20:00")
        val hor2 : AutoCompleteTextView =  view.findViewById(R.id.updateHorFin)
        val adapter2: ArrayAdapter<String> = ArrayAdapter<String>(requireContext(), android.R.layout.simple_list_item_1, finList)
        hor2.setAdapter(adapter2)
        hor2.threshold=0

        view.updateNomPresta.setText(args.currentEntreprise.nomPresta)
        view.updateDom.setText(args.currentEntreprise.dom)
        view.updateAct.setText(args.currentEntreprise.act)
        view.updateHorDeb.setText(args.currentEntreprise.horDebut)
        view.updateHorFin.setText(args.currentEntreprise.horFin)
        view.updateTel.setText(args.currentEntreprise.tel.toString())
        view.updateFax.setText(args.currentEntreprise.fax.toString())
        view.updateGsm.setText(args.currentEntreprise.gsm.toString())
        view.updateEmail.setText(args.currentEntreprise.email)
        view.updateSite.setText(args.currentEntreprise.site)
        view.updateIDImm.setText(args.currentEntreprise.idI.toString())

        view.update_btn2.setOnClickListener {
            updateItem()
        }


        setHasOptionsMenu(true)
        return view
    }

    private fun updateItem() {
        val nomP = updateNomPresta.text.toString()
        val dom = updateDom.text.toString()
        val act = updateAct.text.toString()
        val hor_deb = updateHorDeb.text.toString()
        val hor_fin = updateHorFin.text.toString()
        val tel = updateTel.text
        val fax = updateFax.text
        val gsm = updateGsm.text
        val email = updateEmail.text.toString()
        val site = updateSite.text.toString()
        val idim = updateIDImm.text

        if (inputCheck(nomP, dom, act, hor_deb, hor_fin, tel, fax, gsm, email, site, idim)){
            var updatedEntreprise = Entreprise(args.currentEntreprise.id, nomP, dom, act, hor_deb, hor_fin, Integer.parseInt(tel.toString()), Integer.parseInt(fax.toString()), Integer.parseInt(gsm.toString()), email, site, Integer.parseInt(idim.toString()))
            mEntrepriseViewModel.updateEntreprise(updatedEntreprise)
            Toast.makeText(requireContext(),"Entreprise mis à jour", Toast.LENGTH_SHORT).show()

            findNavController().navigate(R.id.action_updateFragmentEntreprise_to_listFragmentEntreprise)
        }
        else{
            Toast.makeText(requireContext(),"Vérifiez les champs à mettre à jour", Toast.LENGTH_SHORT).show()
        }
    }

    private fun inputCheck(nompp: String, domm:String, actt:String, hor_debb:String, hor_finn: String, tell: Editable,
                           faxx : Editable, gsmm: Editable, emaill:String, sitee:String, idm:Editable): Boolean{
        return !(TextUtils.isEmpty(nompp) && TextUtils.isEmpty(domm) && TextUtils.isEmpty(actt) && TextUtils.isEmpty(hor_debb)
                && TextUtils.isEmpty(hor_finn) && tell.isEmpty() && faxx.isEmpty() && gsmm.isEmpty() && TextUtils.isEmpty(emaill)
                && TextUtils.isEmpty(sitee) && idm.isEmpty())

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.delete_menu2, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId==R.id.menu_delete2){
            deleteUser()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun deleteUser() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setPositiveButton("Oui"){ _, _ ->
            mEntrepriseViewModel.deleteEntreprise(args.currentEntreprise)
            Toast.makeText(requireContext(), "Entreprise de ${args.currentEntreprise.nomPresta} supprimée", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_updateFragmentEntreprise_to_listFragmentEntreprise)
        }
        builder.setNegativeButton("Non"){ _, _ ->
        }
        builder.setTitle("Supprimer l'entreprise de  ${args.currentEntreprise.nomPresta}?")
        builder.setMessage("Êtes vous sure de supprimer l'entreprise de${args.currentEntreprise.nomPresta}?")
        builder.create().show()
    }

}