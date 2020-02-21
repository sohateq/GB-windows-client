import retrofitModel.entity.InfoData;
import retrofitModel.entity.Product;
import retrofitModel.repo.TalosRepo;

import java.io.IOException;
import java.util.List;

public abstract class ClientController {

    public static Balance getBalance () {
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

}
