import org.jetbrains.annotations.NotNull;
import retrofitModel.entity.InfoData;
import retrofitModel.entity.Product;
import retrofitModel.entity.StorageOperation;
import retrofitModel.repo.TalosRepo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ClientController {
    private static ClientController instance;
    private TalosRepo talosRepo;
    private ClientController() {
        talosRepo = TalosRepo.getSingleton();
    }
    public static synchronized ClientController getInstance() {
        if (instance == null) {
            instance = new ClientController();
        }
        return instance;
    }

    public Balance getBalance () {
        Balance balance = new Balance();
        List<InfoData> infoDataList;
        List<Product> products;
        try {
            infoDataList = TalosRepo.getSingleton().getApi().loadInfoData().execute().body();
            products = TalosRepo.getSingleton().getApi().loadProducts().execute().body();
            for (int i = 0; i < infoDataList.size(); i++) {
                String name = infoDataList.get(i).getName();
                double buyingPrice = infoDataList.get(i).getPriceRin();
                double weight = infoDataList.get(i).getWeight();
                if (name.equals("Рама с лестницей (42х1,5)")) {
                    balance.setStairsFrameBuyingPrice(buyingPrice);
                    balance.setStairsFrameWeight(weight);
                }
                if (name.equals("Рама проходная (42х1,5)")) {
                    balance.setPassFrameBuyingPrice(buyingPrice);
                    balance.setPassFrameWeight(weight);
                }
                if (name.equals("Связь диагональная, l=3 м.")) {
                    balance.setDiagonalConnectionBuyingPrice(buyingPrice);
                    balance.setDiagonalConnectionWeight(weight);
                }
                if (name.equals("Связь горизонтальная, l=3 м.")) {
                    balance.setHorizontalConnectionBuyingPrice(buyingPrice);
                    balance.setHorizontalConnectionWeight(weight);
                }
                if (name.equals("Ригель настила, l=3 м.")) {
                    balance.setCrossbarBuyingPrice(buyingPrice);
                    balance.setCrossbarWeight(weight);
                }
                if (name.equals("Настил деревянный 1х1")) {
                    balance.setDeckBuyingPrice(buyingPrice);
                    balance.setDeckWeight(weight);
                }
                if (name.equals("Опора простая (пятки)")) {
                    balance.setSupportsBuyingPrice(buyingPrice);
                    balance.setSupportsWeight(weight);
                }
            }
            for (int i = 0; i < products.size(); i++) {
                String name = products.get(i).getName();
                String status = products.get(i).getStatus();
                int count = (int) products.get(i).getCount();

                if (name.equals("Рама с лестницей (42х1,5)")) {
                    if (status.equals("брак")) {
                        balance.setStairsFrameDefectiveCount(balance.getStairsFrameDefectiveCount() + count);
                    } else {
                        balance.setStairsFrameCount(balance.getStairsFrameCount() + count);
                    }
                }
                if (name.equals("Рама проходная (42х1,5)")) {
                    if (status.equals("брак")) {
                        balance.setPassFrameDefectiveCount(balance.getPassFrameDefectiveCount() + count);
                    } else {
                        balance.setPassFrameCount(balance.getPassFrameCount() + count);
                    }
                }
                if (name.equals("Связь диагональная, l=3 м.")) {
                    if (status.equals("брак")) {
                        balance.setDiagonalConnectionDefectiveCount(balance.getDiagonalConnectionDefectiveCount() + count);
                    } else {
                        balance.setDiagonalConnectionCount(balance.getDiagonalConnectionCount() + count);
                    }
                }
                if (name.equals("Связь горизонтальная, l=3 м.")) {
                    if (status.equals("брак")) {
                        balance.setHorizontalConnectionDefectiveCount(balance.getHorizontalConnectionDefectiveCount() + count);
                    } else {
                        balance.setHorizontalConnectionCount(balance.getHorizontalConnectionCount() + count);
                    }
                }
                if (name.equals("Ригель настила, l=3 м.")) {
                    if (status.equals("брак")) {
                        balance.setCrossbarDefectiveCount(balance.getCrossbarDefectiveCount() + count);
                    } else {
                        balance.setCrossbarCount(balance.getCrossbarCount() + count);
                    }
                }
                if (name.equals("Настил деревянный 1х1")) {
                    if (status.equals("брак")) {
                        balance.setDeckDefectiveCount(balance.getDeckDefectiveCount() + count);
                    } else {
                        balance.setDeckCount(balance.getDeckCount() + count);
                    }
                }
                if (name.equals("Опора простая (пятки)")) {
                    if (status.equals("брак")) {
                        balance.setSupportsDefectiveCount(balance.getSupportsDefectiveCount() + count);
                    } else {
                        balance.setDeckCount(balance.getDeckCount() + count);
                    }
                }
            }
            return balance;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<StorageOperation> getOperationsList () {
        try {
            return talosRepo.getApi().loadOperations().execute().body();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void changeBalance (@NotNull Balance balance) {
        Product [] products = new Product[14];
        products [0] = new Product(1, "Рама с лестницей (42х1,5)", "Ринстрой", "бу",balance.getStairsFrameCount());
        products [1] = new Product(2, "Рама с лестницей (42х1,5)", "Ринстрой", "брак",balance.getStairsFrameDefectiveCount());
        products [2] = new Product(3, "Рама проходная (42х1,5)", "Ринстрой", "бу",balance.getPassFrameCount());
        products [3] = new Product(4, "Рама проходная (42х1,5)", "Ринстрой", "брак",balance.getPassFrameDefectiveCount());
        products [4] = new Product(5, "Связь диагональная, l=3 м.", "Ринстрой", "бу",balance.getDiagonalConnectionCount());
        products [5] = new Product(6, "Связь диагональная, l=3 м.", "Ринстрой", "брак",balance.getDiagonalConnectionDefectiveCount());
        products [6] = new Product(7, "Связь горизонтальная, l=3 м.", "Ринстрой", "бу",balance.getHorizontalConnectionCount());
        products [7] = new Product(8, "Связь горизонтальная, l=3 м.", "Ринстрой", "брак",balance.getHorizontalConnectionDefectiveCount());
        products [8] = new Product(9, "Ригель настила, l=3 м.", "Ринстрой", "бу",balance.getCrossbarCount());
        products [9] = new Product(10, "Ригель настила, l=3 м.", "Ринстрой", "брак",balance.getCrossbarDefectiveCount());
        products [10] = new Product(11, "Настил деревянный 1х1", "Ринстрой", "бу",balance.getDeckCount());
        products [11] = new Product(12, "Настил деревянный 1х1", "Ринстрой", "брак",balance.getDeckDefectiveCount());
        products [12] = new Product(13, "Опора простая (пятки)", "Ринстрой", "бу",balance.getSupportsCount());
        products [13] = new Product(14, "Опора простая (пятки)", "Ринстрой", "брак",balance.getSupportsDefectiveCount());
        for (int i = 0; i < products.length; i++) {
            talosRepo.getApi().editProduct(i+1, products[i]);
        }

        InfoData [] infoDataArr = new InfoData[7];
        infoDataArr [0] = new InfoData(1, "Опора простая (пятки)", balance.getSupportsWeight(), (balance.getSupportsBuyingPrice()/100)*115, balance.getSupportsBuyingPrice(),0.0);
        infoDataArr [1] = new InfoData(2, "Рама проходная (42х1,5)", balance.getPassFrameWeight(), (balance.getPassFrameBuyingPrice()/100)*115, balance.getPassFrameBuyingPrice(), 0.0);
        infoDataArr [2] = new InfoData(3, "Связь диагональная, l=3 м.", balance.getDiagonalConnectionWeight(), (balance.getDiagonalConnectionBuyingPrice()/100)*115, balance.getDiagonalConnectionBuyingPrice(), 0.0);
        infoDataArr [3] = new InfoData(4, "Связь горизонтальная, l=3 м.", balance.getHorizontalConnectionWeight(), (balance.getHorizontalConnectionBuyingPrice()/100)*115, balance.getHorizontalConnectionBuyingPrice(), 0.0);
        infoDataArr [4] = new InfoData(5, "Ригель настила, l=3 м.", balance.getCrossbarWeight(), (balance.getCrossbarBuyingPrice()/100)*115, balance.getCrossbarBuyingPrice(), 0.0);
        infoDataArr [5] = new InfoData(6, "Настил деревянный 1х1", balance.getDeckWeight(), (balance.getDeckBuyingPrice()/100)*115, balance.getDeckBuyingPrice(), 0.0);
        infoDataArr [6] = new InfoData(7, "Рама с лестницей (42х1,5)", balance.getStairsFrameWeight(), (balance.getStairsFrameBuyingPrice()/100)*115, balance.getStairsFrameBuyingPrice(), 0.0);
        for (int i = 0; i < infoDataArr.length; i++) {
            talosRepo.getApi().editInfoData(i+1, infoDataArr[i]);
        }

    }

    public void createOperation (StorageOperation operation) {
        talosRepo.getApi().createOperation(operation);
    }
}
